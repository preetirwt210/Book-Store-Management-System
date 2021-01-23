package com.bookstore.controller.frontend.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.CustomerServices;


@WebServlet("/register_customer")
public class RegisterCustomerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    
    public RegisterCustomerServlet() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices services=new CustomerServices(entityManager,request,response);
		services.registerCustomer();
	}

}
