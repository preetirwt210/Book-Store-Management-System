package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.OrderDAO;
import com.bookstore.entity.BookOrder;

public class OrderServices {

	private EntityManager entityManager;
	private OrderDAO orderDao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public OrderServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		
		super();
		this.request = request;
		this.response = response;
		this.entityManager=entityManager;
		
		orderDao= new OrderDAO(entityManager);
	}

	public void listAllOrder() throws ServletException, IOException {
		List<BookOrder> listOrder=orderDao.listAll();
		
		request.setAttribute("listOrder", listOrder);
		
		String listPage="order_list.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		
	}

	public void viewOrderDetailForAdmin() throws ServletException, IOException {
		int orderId=Integer.parseInt(request.getParameter("id"));
		
		BookOrder order=orderDao.get(orderId);
		request.setAttribute("order", order);
		
		String detailPage="order_detail.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(detailPage);
		dispatcher.forward(request, response);
		
	}

}
