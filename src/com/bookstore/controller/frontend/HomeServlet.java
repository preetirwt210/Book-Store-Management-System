package com.bookstore.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;


@WebServlet("")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HomeServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		CategoryDAO categoryDAO=new CategoryDAO(entityManager);
		BookDAO bookDao=new BookDAO(entityManager);
		
		List<Category> listCategory = categoryDAO.listAll();
		List<Book> listNewBooks=bookDao.listNewBooks();
		List<Book> listBestSellingBooks=bookDao.listBestSellingBooks();
		List<Book> listMostFavoredBooks=bookDao.listMostFavoredBooks();
		
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("listNewBooks", listNewBooks);
		request.setAttribute("listBestSellingBooks", listBestSellingBooks);
		request.setAttribute("listMostFavoredBooks", listMostFavoredBooks);
		
		
		String homepage="frontend/index.jsp";
		RequestDispatcher dispatcher= request.getRequestDispatcher(homepage);
		dispatcher.forward(request, response);
	}

}
