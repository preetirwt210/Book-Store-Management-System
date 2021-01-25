package com.bookstore.controller.admin.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.ReviewServices;


@WebServlet("/admin/list_review")
public class ListReviewServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public ListReviewServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewServices services=new ReviewServices(entityManager,request,response);
		 services.listAllReviews();
	}

}
