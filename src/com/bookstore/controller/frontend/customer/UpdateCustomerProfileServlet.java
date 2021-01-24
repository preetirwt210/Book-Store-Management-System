package com.bookstore.controller.frontend.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.CustomerServices;


@WebServlet("/update_profile")
public class UpdateCustomerProfileServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    
    public UpdateCustomerProfileServlet() {
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             CustomerServices services=new CustomerServices(entityManager,request,response);
             services.updateCustomerProfile();
	}

}
