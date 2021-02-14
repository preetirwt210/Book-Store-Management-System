package com.bookstore.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.controller.frontend.shopingcart.ShoppingCart;
import com.bookstore.dao.OrderDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;

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
		listAllOrder(null);
		}

	public void listAllOrder( String message) throws ServletException, IOException {
		List<BookOrder> listOrder=orderDao.listAll();
		
		if(message !=null) {
			request.setAttribute("message", message);
		}
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

	public void showCheckoutForm() throws ServletException, IOException {
		String checkoutPage="frontend/checkout.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(checkoutPage);
		dispatcher.forward(request, response);
		
	}

	public void placeOrder() throws ServletException, IOException {
		String recipientName=request.getParameter("recipientName");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String zipcode=request.getParameter("zipcode");
		String country=request.getParameter("country");
		String paymentMethod=request.getParameter("paymentMethod");
		String shippingAddress=address + "," + city + "," +zipcode + "," +country;
		
		BookOrder order=new BookOrder();
		order.setRecipientName(recipientName);
		order.setRecipientPhone(phone);
		order.setShippingAddress(shippingAddress);
		order.setPaymentMethod(paymentMethod);
		
		HttpSession session=request.getSession();
		Customer customer=(Customer) session.getAttribute("loggedCustomer");
		order.setCustomer(customer);
		
		ShoppingCart shoppingCart=(ShoppingCart) session.getAttribute("cart");
		Map<Book, Integer> items=shoppingCart.getItems();
		
		Iterator<Book> iterator=items.keySet().iterator();
		
		Set<OrderDetail> orderDetails=new HashSet<>();
		
		while(iterator.hasNext()) {
			Book book=iterator.next();
			Integer quantity=items.get(book);
			float subtotal= quantity*book.getPrice();
			
			OrderDetail orderDetail=new OrderDetail();
			
			orderDetail.setBook(book);
			orderDetail.setBookOrder(order);
			orderDetail.setQuantity(quantity);
			orderDetail.setSubtotal(subtotal);
			
			
			orderDetails.add(orderDetail);
		}
		
		order.setOrderDetails(orderDetails);
		order.setTotal(shoppingCart.getTotalAmount());
		
		orderDao.create(order);
		
		shoppingCart.clear();
		String message="ThankYou. Your order has been recieved."
				+" We will deliver your books within a few days";
		
		request.setAttribute("message", message);
		String messagePage="frontend/message.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(messagePage);
		dispatcher.forward(request, response);
		
	}

	public void listOrderByCustomer() throws ServletException, IOException {
		HttpSession session=request.getSession();
		Customer customer=(Customer) session.getAttribute("loggedCustomer");
		List<BookOrder> listOrders=orderDao.listByCustomer(customer.getCustomerId());
		
		request.setAttribute("listOrders", listOrders);
		String historyPage="frontend/order_list.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(historyPage);
		dispatcher.forward(request, response);
		
	}

	public void showOrderDetailForCustomer() throws ServletException, IOException {
				int orderId=Integer.parseInt(request.getParameter("id"));
		HttpSession session=request.getSession();
		Customer customer=(Customer) session.getAttribute("loggedCustomer");
		
		BookOrder order=orderDao.get(orderId);
		request.setAttribute("order", order);
		
		String detailPage="frontend/order_detail.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(detailPage);
		dispatcher.forward(request, response);
		
	}

	public void showEditOrderForm() throws ServletException, IOException {
		
		Integer orderId=Integer.parseInt(request.getParameter("id"));
		
		HttpSession session=request.getSession();
		
		Object isPendingBook=session.getAttribute("NewBookPendingToAddToOrder");
		
		if(isPendingBook == null) {
			
		BookOrder order=orderDao.get(orderId);
		session.setAttribute("order", order);
		}
		
		else {
			session.removeAttribute("NewBookPendingToAddToOrder");
		}
		String editPage="order_form.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
		
	}

	public void updateOrder() throws ServletException, IOException {
		HttpSession session=request.getSession();
		BookOrder order=(BookOrder) session.getAttribute("order");
		
		String recipientName=request.getParameter("name");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String paymentMethod=request.getParameter("paymentMethod");
		String orderStatus=request.getParameter("orderStatus");
		
		order.setRecipientName(recipientName);
		order.setRecipientPhone(phone);
		order.setShippingAddress(address);
		order.setPaymentMethod(paymentMethod);
		order.setStatus(orderStatus);
		
		String[] arrayBookId=request.getParameterValues("bookId");
		String[] arrayPrice=request.getParameterValues("price");
		String[] arrayQuantity=new String[arrayBookId.length];
		
		for(int i=1;i<=arrayQuantity.length; i++) {
			arrayQuantity[i-1] = request.getParameter("quantity" + i);
			
		}
		Set<OrderDetail> orderDetails=order.getOrderDetails();
		orderDetails.clear();
		

		float totalAmount=0.0f;
		
		for(int i=0; i<arrayBookId.length; i++) {
			int bookId=Integer.parseInt(arrayBookId[i]);
			int quantity=Integer.parseInt(arrayQuantity[i]);
			float price=Float.parseFloat(arrayPrice[i]);
			
			float subtotal=price*quantity;
			
			OrderDetail orderDetail=new OrderDetail();
			orderDetail.setBook(new Book(bookId));
			orderDetail.setQuantity(quantity);
			orderDetail.setSubtotal(subtotal);
			orderDetail.setBookOrder(order);	
			
			orderDetails.add(orderDetail);
			
			totalAmount +=subtotal;
		}
		
		order.setTotal(totalAmount);
		orderDao.update(order);
		
		String message="the order " + order.getOrderId() + " has been updated Successfully";
		listAllOrder(message);
		
		
		
	}

	public void deleteOrder() throws ServletException, IOException {
		Integer orderId=Integer.parseInt(request.getParameter("id"));
		
		orderDao.delete(orderId);
		String message="The order Id " + orderId +  " has been Deleted successfully";
		
		listAllOrder(message);
		
	}

}
