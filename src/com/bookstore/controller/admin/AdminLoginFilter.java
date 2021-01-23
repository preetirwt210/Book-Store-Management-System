package com.bookstore.controller.admin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

   
    public AdminLoginFilter() {
    }
	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpSession session=httpRequest.getSession(false);
		
		boolean loggedIn= session !=null && session.getAttribute("useremail") !=null;
		String loginURI= httpRequest.getContextPath() + "/admin/login";
		boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
		boolean loginPage = httpRequest.getRequestURI().endsWith("login.jsp");
		
		if(loggedIn && (loginRequest || loginPage)) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/admin/");
			dispatcher.forward(httpRequest, response);
		}
		if(loggedIn || loginRequest) {
			System.out.println("use logged in");
			chain.doFilter(httpRequest, response);
		}
		else {
			System.out.println("use logged in");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(httpRequest, response);
		}
		System.out.println("AdminLoginFilter is invoked");
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
