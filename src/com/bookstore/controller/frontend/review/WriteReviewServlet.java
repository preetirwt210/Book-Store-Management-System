package com.bookstore.controller.frontend.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.ReviewServices;


@WebServlet("/write_review")
public class WriteReviewServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

   
    public WriteReviewServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewServices services=new ReviewServices(entityManager,request,response);
		services.showReviewForm();
	}

}
