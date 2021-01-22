package com.bookstore.controller.frontend.books;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.BookServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/view_books")
public class ViewBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public ViewBookServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookServices bookServices=new BookServices(entityManager,request,response);
		bookServices.viewBookDetails();
		
	}

}
