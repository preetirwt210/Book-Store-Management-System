package com.bookstore.controller.frontend.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.CustomerServices;
import com.bookstore.service.UserServices;


@WebServlet("/view_profile")
public class ShowCustomerProfileServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    
    public ShowCustomerProfileServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices services=new CustomerServices(entityManager,request,response);
		services.showCustomerProfile();
	}

}
