package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			String message="Cannot create customer because the email: " + email + "Already exists";
			listCustomers(message);
		}
		Customer newCustomer=new Customer();
		updateCustomerFieldsFromForm(newCustomer);
		customerDao.create(newCustomer);
		listCustomers("New Customer created successfully");
		
	}
	private void updateCustomerFieldsFromForm(Customer customer) {
		String email=request.getParameter("email");
		String fullname=request.getParameter("fullname");
		String password=request.getParameter("password");
		String 	phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String zip=request.getParameter("zip");
		String country=request.getParameter("country");
		
		
		if(email!=null && !email.equals("")) {
		customer.setEmail(email);
		}
		customer.setFullname(fullname);
		if(password!=null && !password.equals("")){
		customer.setPassword(password);
		}
		customer.setPhone(phone);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setZipcode(zip);
		customer.setCountry(country);
	}
	
	public void registerCustomer() throws ServletException, IOException {
		String email=request.getParameter("email");
		Customer existCustomer=customerDao.findByEmail(email);
		String message="";
		if(existCustomer!=null) {
			 message="Cannot register customer because the email: " + email + " is already registered ";
		}else {
		
			Customer newCustomer=new Customer();
			updateCustomerFieldsFromForm(newCustomer);
		customerDao.create(newCustomer);
		
		message="You have registered successfully!!Thankyou.<br/>"
				+ "<a href='login'>Click here </a> to login.";
	}
		String messagePage="frontend/message.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(messagePage);
		request.setAttribute("message", message);
		dispatcher.forward(request, response);
		
		
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
			message="Could not update the Customer Id" + customerId +
					"because ther's an existing customer having the same email.";
		}else {
			
			Customer customerById=customerDao.get(customerId);
			updateCustomerFieldsFromForm(customerById);
			
			customerDao.update(customerById);
			message="Customer has been successfully updated";
		}
		listCustomers(message);
	}

	public void deleteCustomer() throws ServletException, IOException {
		Integer customerId=Integer.parseInt(request.getParameter("id"));
		customerDao.delete(customerId);
		listCustomers("Customer has been deleted successfully!");
	}

	public void showLogin() throws ServletException, IOException {
		String loginPage="frontend/login.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(loginPage);
		dispatcher.forward(request, response);
	}

	public void doLogin() throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		Customer customer=customerDao.checkLogin(email, password);
		if(customer==null) {
			String message="Login failed.Please check your email and password.";
			request.setAttribute("message", message);
			showLogin();
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("loggedCustomer", customer);
			
			Object objRedirectURL=session.getAttribute("redirectURL");
			
			if(objRedirectURL !=null) {
				String redirectURL=(String) objRedirectURL;
				session.removeAttribute("redirectURL");
				response.sendRedirect(redirectURL);
			}
			else {
			showCustomerProfile();
			}
		}
		
	}
	public void showCustomerProfile() throws ServletException, IOException {
		String profilePage="frontend/customer_profile.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(profilePage);
		dispatcher.forward(request, response);
	}

	public void showCustomerProfileEditForm() throws ServletException, IOException {
		String profilePage="frontend/edit_profile.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(profilePage);
		dispatcher.forward(request, response);
		
		
	}

	public void updateCustomerProfile() throws ServletException, IOException {
		Customer customer=(Customer) request.getSession().getAttribute("loggedCustomer");
		updateCustomerFieldsFromForm(customer);
		customerDao.update(customer);
		
		showCustomerProfile();
		
	}

	
	
	
}
