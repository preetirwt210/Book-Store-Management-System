package com.bookstore.controller.admin.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.CustomerServices;


@WebServlet("/admin/list_customers")
public class ListCustomerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public ListCustomerServlet() { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CustomerServices customerServices=new CustomerServices(entityManager,request,response);
		customerServices.listCustomers();
	}

}
