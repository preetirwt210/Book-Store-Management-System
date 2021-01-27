package com.bookstore.controller.admin.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.ReviewServices;

@WebServlet("/admin/delete_review")
public class DeleteReviewServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public DeleteReviewServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewServices services=new ReviewServices(entityManager,request,response);
		services.deleteReview();
	}

}
