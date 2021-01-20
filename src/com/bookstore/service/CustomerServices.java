package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.dao.CustomerDAO;
import com.bookstore.entity.Customer;

public class CustomerServices extends BaseServlet {

	private EntityManager entityManager;
	private CustomerDAO customerDao;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CustomerServices(
		EntityManager entityManager,HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.entityManager=entityManager;
		
		
		customerDao= new CustomerDAO(entityManager);
	}

	public void listCustomers() throws ServletException, IOException {
		List<Customer> listCustomer=customerDao.listAll();
		
		request.setAttribute("listCustomer", listCustomer);
		String listPage="customer_list.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
	
}
