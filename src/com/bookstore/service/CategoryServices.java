package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.admin.BaseServlet;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

public class CategoryServices extends BaseServlet {

	
	private EntityManager entityManager;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CategoryServices(
		EntityManager entityManager,HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.entityManager=entityManager;
		
		
		categoryDAO= new CategoryDAO(entityManager);
	}

	public void listCategory(String message) throws ServletException, IOException {
		
		List<Category> listCategory=categoryDAO.listAll();
		
		request.setAttribute("listCategory", listCategory);
		if(message !=null) {
		request.setAttribute("message", message);
		}
		String listPage= "category_list.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		
	}
	
	public void createCategory() throws ServletException, IOException {
		String name=request.getParameter("name");
		Category existCategory=categoryDAO.findByName(name);
		
		if(existCategory !=null) {
			String message ="Could not create category. "
					+ "A category with name " + name + "already exists.";
			request.setAttribute("message", message);
			
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			Category newCategory=new Category(name);
			categoryDAO.create(newCategory);
			
			String message="New Category created successfully!!";
			listCategory(message);
			
		}
	}

	public void listCategory() throws ServletException, IOException {
		listCategory(null);
	}
	
	
	
	
}
