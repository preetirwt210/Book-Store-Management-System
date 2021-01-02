package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
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

	public void editCategory() throws ServletException, IOException {
		int categoryId =Integer.parseInt(request.getParameter("id"));
		Category category=categoryDAO.get(categoryId);
		request.setAttribute("category",category);
		
		String editPage="category_form.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(editPage);
		dispatcher.forward(request,response);
		
	}

	public void updateCategory() throws ServletException, IOException {
		int categoryId =Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("name");
		
		Category categoryById = categoryDAO.get(categoryId);
		Category  categoryByName= categoryDAO.findByName(categoryName);
		
		if(categoryByName != null && categoryById.getCategoryId() != categoryByName.getCategoryId()) {
			String message = "Could not update category. "
					+ " A category with name " + categoryName + " already exists.";
			
			request.setAttribute("message",message);
			RequestDispatcher dispatcher=request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request,response);
		}
		else {
			categoryById.setName(categoryName);
			categoryDAO.update(categoryById);
			String message ="Category has been updated successfully";
			listCategory(message);
		}
		
		
	}

	public void deleteCategory() throws ServletException, IOException {
		int categoryId =Integer.parseInt(request.getParameter("id"));
		categoryDAO.delete(categoryId);
		
		String message = "The category with ID " + categoryId + "has been removed succeffully.";
		listCategory(message);
		
		
	}
	
	
	
	
}
