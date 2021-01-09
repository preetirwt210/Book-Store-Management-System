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
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookServices  {
	private EntityManager entityManager;
	private BookDAO bookDAO;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

public BookServices(
		EntityManager entityManager,HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.entityManager=entityManager;
		
		bookDAO= new BookDAO(entityManager);
		categoryDAO= new CategoryDAO(entityManager);
	}

	public void listBooks() throws ServletException, IOException {
		
		List<Book> listBooks=bookDAO.listAll();
		request.setAttribute("listBooks", listBooks);
		
		String listPage="book_list.jsp";
		RequestDispatcher dispatcher= request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
	public void showNewBookForm() throws ServletException, IOException {
		List<Category> listCategory=categoryDAO.listAll();
		request.setAttribute("listCategory", listCategory);
		
		String newPage="book_form.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(newPage);
		dispatcher.forward(request, response);
	}
}