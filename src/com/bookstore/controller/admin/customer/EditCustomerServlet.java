package com.bookstore.controller.admin.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.CustomerServices;


@WebServlet("/admin/edit_customer")
public class EditCustomerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public EditCustomerServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices service=new CustomerServices(entityManager,request,response);
		service.editCutomers();
	}

}
