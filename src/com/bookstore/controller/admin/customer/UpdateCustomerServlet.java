package com.bookstore.controller.admin.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.CustomerServices;


@WebServlet("/admin/update_customer")
public class UpdateCustomerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

   
    public UpdateCustomerServlet() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          CustomerServices services=new CustomerServices(entityManager,request,response);
          services.updateCustomer();
	}

}
