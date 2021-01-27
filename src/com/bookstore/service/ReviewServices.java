package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.ReviewDAO;
import com.bookstore.entity.Review;

public class ReviewServices {
	private EntityManager entityManager;
	private ReviewDAO reviewDao;
	private BookDAO bookDAO;
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
    
    
}
