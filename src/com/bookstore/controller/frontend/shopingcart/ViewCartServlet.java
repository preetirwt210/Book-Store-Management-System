package com.bookstore.controller.frontend.shopingcart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;


@WebServlet("/view_cart")
public class ViewCartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public ViewCartServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Object cartObject = request.getSession().getAttribute("cart");    
		
	    if(cartObject==null) {
	    	ShoppingCart shoppingCart=new ShoppingCart();
	    	request.getSession().setAttribute("cart", shoppingCart);
	    	
	    }
	    
		String cartPage="frontend/shopping_cart.jsp";
	         RequestDispatcher dispatcher=request.getRequestDispatcher(cartPage);
	         dispatcher.forward(request, response);
	}

}
