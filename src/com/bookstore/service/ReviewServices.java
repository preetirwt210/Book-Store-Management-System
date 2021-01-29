package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.ReviewDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;

public class ReviewServices {
	private EntityManager entityManager;
	private ReviewDAO reviewDao;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

    public ReviewServices(
		EntityManager entityManager,HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.entityManager=entityManager;
		
		reviewDao= new ReviewDAO(entityManager);
		categoryDAO= new CategoryDAO(entityManager);
	}
    public void listAllReviews() throws ServletException, IOException {
    	listAllReviews(null);
    }

	public void listAllReviews(String message) throws ServletException, IOException {
		List<Review> listReviews=reviewDao.listAll();
		
		request.setAttribute("listReviews", listReviews);
		if(message!=null) {
			request.setAttribute("message", message);
		}
		String listPage="review_list.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		
	}

	public void editReview() throws ServletException, IOException {
              Integer reviewId=Integer.parseInt(request.getParameter("id"));
              Review review=reviewDao.get(reviewId);
              
              request.setAttribute("review", review);
              
              String editPage="review_form.jsp";
              RequestDispatcher dispatcher=request.getRequestDispatcher(editPage);
              dispatcher.forward(request, response);
	}

	public void updateReview() throws ServletException, IOException {
		Integer reviewId=Integer.parseInt(request.getParameter("reviewId"));
		String headline=request.getParameter("headline");
		String comment=request.getParameter("comment");
		
		Review review=reviewDao.get(reviewId);
		review.setHeadline(headline);
		review.setComment(comment);
		
		reviewDao.update(review);
		
		String message="Review has been successfully update!";
		
		listAllReviews(message);
	}
	public void deleteReview() throws ServletException, IOException {
		Integer reviewId=Integer.parseInt(request.getParameter("id"));
		
		reviewDao.delete(reviewId);
		String message="Review has been successfully deleted";
		listAllReviews(message);
		
	}
	
	public void showReviewForm() throws ServletException, IOException {
		
		Integer bookId=Integer.parseInt(request.getParameter("book_id"));
		BookDAO bookDao=new BookDAO(entityManager);
		
		Book book=bookDao.get(bookId);
		HttpSession session=request.getSession();
		session.setAttribute("book", book);
		
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		
		Review existReview = reviewDao.findByCustomerAndBook(customer.getCustomerId(), bookId);
		
		String targetPage="frontend/review_form.jsp";
		if(existReview !=null) {
			request.setAttribute("review", existReview);
			targetPage="frontend/review_info.jsp";
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(targetPage);
		dispatcher.forward(request, response);
		
	}
	public void submitReviewForm() throws ServletException, IOException {
		Integer bookId=Integer.parseInt(request.getParameter("bookId"));
		Integer rating=Integer.parseInt(request.getParameter("rating"));
		String headline= request.getParameter("headline");
		String comment = request.getParameter("comment");
		
		Review newReview=new Review();
		newReview.setHeadline(headline);
		newReview.setComment(comment);
		newReview.setRating(rating);
		
		Book book=new Book();
		book.setBookId(bookId);
		newReview.setBook(book);
		
		Customer customer=(Customer) request.getSession().getAttribute("loggedCustomer");
		newReview.setCustomer(customer);
		
		reviewDao.create(newReview);
		String messagePage="frontend/review_done.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(messagePage);
		dispatcher.forward(request, response);
	}
    
    
}
