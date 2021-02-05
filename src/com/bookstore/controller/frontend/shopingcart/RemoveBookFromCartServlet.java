package com.bookstore.controller.frontend.shopingcart;

import com.bookstore.controller.BaseServlet;
import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/remove_from_cart")
public class RemoveBookFromCartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

   
    public RemoveBookFromCartServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer bookId=Integer.parseInt(request.getParameter("book_id"));
		Object cartObject=request.getSession().getAttribute("cart");
		
		ShoppingCart shoppingCart =(ShoppingCart) cartObject;
		
		shoppingCart.removeItem(new Book(bookId));
		
		String cartPage= request.getContextPath().concat("/view_cart");
		response.sendRedirect(cartPage);
		
	}

}
