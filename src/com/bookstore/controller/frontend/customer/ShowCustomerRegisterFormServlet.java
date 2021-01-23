package com.bookstore.controller.frontend.customer;

import com.bookstore.controller.BaseServlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class ShowCustomerRegisterFormServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    
    public ShowCustomerRegisterFormServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String registerForm="frontend/register_form.jsp";
	RequestDispatcher dispatcher=request.getRequestDispatcher(registerForm);
	dispatcher.forward(request, response);
	}

}
