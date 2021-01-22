package com.bookstore.controller.admin.customer;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.CustomerServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/delete_customer")
public class DeleteCustomerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    
    public DeleteCustomerServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices services=new CustomerServices(entityManager,request,response);
		services.deleteCustomer();
	}

}
