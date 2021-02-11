package com.bookstore.controller.admin.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.OrderServices;


@WebServlet("/admin/edit_order")
public class EditOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    
    public EditOrderServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServices services=new OrderServices(entityManager,request,response);
		services.showEditOrderForm();
	}

}
