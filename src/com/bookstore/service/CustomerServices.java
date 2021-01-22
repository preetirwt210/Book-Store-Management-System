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
		listCustomers(null);
	}
	public void listCustomers(String message) throws ServletException, IOException {
		List<Customer> listCustomer=customerDao.listAll();
		
		if(message!=null){
			request.setAttribute("message", message);
		}
		request.setAttribute("listCustomer", listCustomer);
		String listPage="customer_list.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}

	public void createCustomer() throws ServletException, IOException {
		String email=request.getParameter("email");
		Customer existCustomer=customerDao.findByEmail(email);
		if(existCustomer!=null) {
			String message="Cannot register customer because the email: " + email + "Already exists";
			listCustomers(message);
		}
		String fullname=request.getParameter("fullname");
		String password=request.getParameter("password");
		String 	phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String zip=request.getParameter("zip");
		String country=request.getParameter("country");
		
		
		Customer newCustomer=new Customer();
		newCustomer.setEmail(email);
		newCustomer.setFullname(fullname);
		newCustomer.setPassword(password);
		newCustomer.setPhone(phone);
		newCustomer.setAddress(address);
		newCustomer.setCity(city);
		newCustomer.setZipcode(zip);
		newCustomer.setCountry(country);
		
		customerDao.create(newCustomer);
		listCustomers("New Customer created successfully");
		
	}

	public void editCutomers() throws ServletException, IOException {
		int customerId=Integer.parseInt(request.getParameter("id"));
		Customer customer=customerDao.get(customerId);
		
		request.setAttribute("customer", customer);
		
		String editPage="customer_form.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}

	public void updateCustomer() throws ServletException, IOException {
		Integer customerId=Integer.parseInt(request.getParameter("customerId"));
	
		String email=request.getParameter("email");
		Customer customerByEmail=customerDao.findByEmail(email);
		String message=null;
		if(customerByEmail !=null && customerByEmail.getCustomerId() != customerId) {
			message="Could not update the Csutomer Id" + customerId +
					"because ther's an existing customer having the same email.";
		}else {
			String fullname=request.getParameter("fullname");
			String password=request.getParameter("password");
			String 	phone=request.getParameter("phone");
			String address=request.getParameter("address");
			String city=request.getParameter("city");
			String zip=request.getParameter("zip");
			String country=request.getParameter("country");
			
			Customer customerById=customerDao.get(customerId);
			customerById.setEmail(email);
			customerById.setFullname(fullname);
			customerById.setPassword(password);
			customerById.setPhone(phone);
			customerById.setAddress(address);
			customerById.setCity(city);
			customerById.setCity(city);
			customerById.setZipcode(zip);
			customerById.setCountry(country);
			
			customerDao.update(customerById);
			
		}
		listCustomers("Customer has been successfully updated");
	}

	public void deleteCustomer() throws ServletException, IOException {
		Integer customerId=Integer.parseInt(request.getParameter("id"));
		customerDao.delete(customerId);
		listCustomers("Customer has been deleted successfully!");
	}
	
	
}
