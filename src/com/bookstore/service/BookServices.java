package com.bookstore.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookServices  {
	private EntityManager entityManager;
	private BookDAO bookDAO;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

public BookServices(
		EntityManager entityManager,HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.entityManager=entityManager;
		
		bookDAO= new BookDAO(entityManager);
		categoryDAO= new CategoryDAO(entityManager);
	}

		public void listBooks() throws ServletException, IOException {
			listBooks(null);
		}

	public void listBooks(String message) throws ServletException, IOException {
		
		List<Book> listBooks=bookDAO.listAll();
		request.setAttribute("listBooks", listBooks);
		
		if(message!=null) {
			request.setAttribute("message", message);
			}
		
		String listPage="book_list.jsp";
		RequestDispatcher dispatcher= request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
	public void showNewBookForm() throws ServletException, IOException {
		List<Category> listCategory=categoryDAO.listAll();
		request.setAttribute("listCategory", listCategory);
		
		String newPage="book_form.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(newPage);
		dispatcher.forward(request, response);
	}
	
	public void createBook() throws ServletException, IOException {
		Integer categoryId= Integer.parseInt(request.getParameter("category"));
		String  title=request.getParameter("title");
		
		Book existBook=bookDAO.findByTitle(title);
		if(existBook !=null) {
			String message="Could not create new book because the title: " + title + " Already exist.";
			listBooks(message);
			return;
		}
		
		String  author=request.getParameter("author");
		String  isbn=request.getParameter("isbn");
		float  price=Float.parseFloat(request.getParameter("price"));
		String  description=request.getParameter("description");
		
		DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate=null;
			 try {
				publishDate=dateFormat.parse(request.getParameter("publishDate"));
			} catch (java.text.ParseException e) {
				e.printStackTrace();
				throw new ServletException("Error parsing publish Date(Format is MM/dd/yyyy)");
			}
		
		
		
		Book newBook=new Book();
		newBook.setAuthor(author);
		newBook.setTitle(title);
		newBook.setIsbn(isbn);
		newBook.setPrice(price);
		newBook.setDescription(description);
		newBook.setPublishDate(publishDate);
		
		Category category=categoryDAO.get(categoryId);
		newBook.setCategory(category);
		
		Part part=request.getPart("image");
		if(part !=null && part.getSize()>0) {
			long size=part.getSize();
			byte[] imageBytes=new byte[(int) size];
			
			InputStream inputStream=part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			
			newBook.setImage(imageBytes);
		}
		Book createdBook=bookDAO.create(newBook);
		
		if(createdBook.getBookId()>0) {
			String message="Book has been successfully created!!";
			
			listBooks(message);
		}
	}

	public void editBook() throws ServletException, IOException {
		Integer bookId=Integer.parseInt(request.getParameter("id"));
		Book book=bookDAO.get(bookId);
		
		List<Category> listCategory=categoryDAO.listAll();
		
		
		request.setAttribute("book", book);
		request.setAttribute("listCategory", listCategory);
		String newPage="book_form.jsp";
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(newPage);
		dispatcher.forward(request, response);
		
		
	}

	public void updateBook() throws ServletException, IOException {
		Integer bookId=Integer.parseInt(request.getParameter("bookId"));
		
		Book existBook=bookDAO.get(bookId);
		
		
		Integer categoryId= Integer.parseInt(request.getParameter("category"));
		String  title=request.getParameter("title");
		String  author=request.getParameter("author");
		String  isbn=request.getParameter("isbn");
		float  price=Float.parseFloat(request.getParameter("price"));
		String  description=request.getParameter("description");
		
		DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate=null;
			 try {
				publishDate=dateFormat.parse(request.getParameter("publishDate"));
			} catch (java.text.ParseException e) {
				e.printStackTrace();
				throw new ServletException("Error parsing publish Date(Format is MM/dd/yyyy)");
			}
		
			 existBook.setAuthor(author);
			 existBook.setTitle(title);
			 existBook.setIsbn(isbn);
			 existBook.setPrice(price);
			 existBook.setDescription(description);
			 existBook.setPublishDate(publishDate);
		
		Category category=categoryDAO.get(categoryId);
		existBook.setCategory(category);
		
		Part part=request.getPart("image");
		if(part !=null && part.getSize()>0) {
			long size=part.getSize();
			byte[] imageBytes=new byte[(int) size];
			
			InputStream inputStream=part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			
			existBook.setImage(imageBytes);   
		}
		Book bookByTitle=bookDAO.findByTitle(title);
		if(!existBook.equals(bookByTitle)) {
			String message="Could not update Book beacuse there is another book with same title";
			listBooks(message);
			return;
		}
		bookDAO.update(existBook);
		 String message="Book Has been successfully updated.";
				 listBooks(message);
		
		
	}

	public void deleteBook() throws ServletException, IOException {
		Integer bookId=Integer.parseInt(request.getParameter("id"));
		
		bookDAO.delete(bookId);
		
		String message="The Book has been deleted successfully";
		listBooks(message);
		
	}

	public void listBooksByCategory() throws ServletException, IOException {
		
		int categoryId=Integer.parseInt(request.getParameter("id"));
		List<Book> listBooks=bookDAO.listByCategory(categoryId);
		Category category=categoryDAO.get(categoryId);
		List<Category> listCategory=categoryDAO.listAll();
		
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("listBooks", listBooks);
		request.setAttribute("category", category);
		
		String listPage="frontend/books_list_by_category.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}