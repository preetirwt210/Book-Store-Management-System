package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookDAOTest extends BaseDAOTest {
	private static BookDAO bookDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		BaseDAOTest.setUpBeforeClass();
		bookDao=new BookDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

	@Test
	public void testCreateBook() throws ParseException, IOException {
		
		Book newbook=new Book();
		
		Category cat= new Category("Advance Java");
		cat.setCategoryId(2);
		newbook.setCategory(cat);
		newbook.setTitle("Effective Java (2nd Edition)");
		newbook.setAuthor("Joshua Bloch");
		newbook.setDescription("New coverage of generics, enums, annotations, autoboxing,"
				+ " the for-each loop, varargs, concurrency utilities, and much more."
				+ "");
		newbook.setIsbn("0321356683");
		newbook.setPrice(30.57f);
		
		DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate=dateFormat.parse("05/01/2021");
		newbook.setPublishDate(publishDate);
		
		String imagePath = "C:\\Users\\Preeti Rawat\\Downloads\\books\\Effective Java.JPG";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newbook.setImage(imageBytes);
		
		Book createdBook = bookDao.create(newbook);
		
		assertTrue(createdBook.getBookId() >0);
	}

	@Test
	public void testUpdateBook() throws ParseException, IOException {
		Book existingBook=new Book();
		existingBook.setBookId(1);
		
		Category cat= new Category("Core Java");
		cat.setCategoryId(1);
		existingBook.setCategory(cat);
		existingBook.setTitle("Effective Java (3rd Edition)");
		existingBook.setAuthor("Joshua Bloch");
		existingBook.setDescription("New coverage of generics, enums, annotations, autoboxing,"
				+ " the for-each loop, varargs, concurrency utilities, and much more."
				+ "");
		existingBook.setIsbn("0321356683");
		existingBook.setPrice(40);
		
		DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate=dateFormat.parse("05/01/2021");
		existingBook.setPublishDate(publishDate);
		
		String imagePath = "C:\\Users\\Preeti Rawat\\Downloads\\books\\Effective Java.JPG";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		existingBook.setImage(imageBytes);
		
		Book updatedBook = bookDao.update(existingBook);
		
		assertEquals(updatedBook.getTitle(),"Effective Java (3rd Edition)");
	
	}
	
	@Test
public void testCreate2ndBook() throws ParseException, IOException {
		
		Book newbook=new Book();
		
		Category cat= new Category("Advance Java");
		cat.setCategoryId(2);
		newbook.setCategory(cat);
		newbook.setTitle("Java 8 in Action");
		newbook.setAuthor("Raoul-Gabriel Urma, Mario Fusco, Alan Mycroft");
		newbook.setDescription("New coverage of generics, enums, annotations, autoboxing,"
				+ " the for-each loop, varargs, concurrency utilities, and much more."
				+ "");
		newbook.setIsbn("1617291994");
		newbook.setPrice(36.72f);
		
		DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate=dateFormat.parse("28/01/2021");
		newbook.setPublishDate(publishDate);
		
		String imagePath = "C:\\Users\\Preeti Rawat\\Downloads\\books\\Java 8 in Action.JPG";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newbook.setImage(imageBytes);
		
		Book createdBook = bookDao.create(newbook);
		
		assertTrue(createdBook.getBookId() >0);
	}



	@Test
	public void testGetBookSuccess() {
		Integer bookId=2;
		Book book =bookDao.get(bookId);
		assertNotNull(book);
		
	}

	@Test
	public void testDeleteBookSuccess() {
		
		Integer bookId=3;
		bookDao.delete(bookId);
		
		assertTrue(true);
	}
	@Test
	public void testSearchBookInTitle() {
		String keyword="Kathy";
		List<Book> result = bookDao.search(keyword);
		
		assertEquals(1,result.size());
	}

	@Test
	public void testListAll() {

    List<Book> listBooks=bookDao.listAll();
    
    for(Book abook : listBooks) {
    	System.out.println(abook.getTitle() + "-" + abook.getAuthor());
    }
    
    assertFalse(listBooks.isEmpty());
		
	}

	@Test
	public void testFindByTitleNotExist() {
		String title="ThinkIn Java";
		Book book= bookDao.findByTitle(title);
		assertNull(book);
	}
	
	@Test
	public void testFindByTitleExist() {
		String title="Effective Java (2nd Edition)";
		Book book= bookDao.findByTitle(title);
		System.out.println(book.getAuthor() );
		assertNotNull(book);
	}
	@Test
	public void testListByCategory() {
		int categoryId=2;
		List<Book> listBooks=bookDao.listByCategory(categoryId);
		
		assertTrue(listBooks.size()>0);
	}
	
	@Test
	public void testCountByCategory() {
		int categoryId=2;
		long numOfBooks= bookDao.countByCategory(categoryId);
		assertTrue(numOfBooks == 3);
	}
	
	@Test
	public void testNewBooks() {
		
		List<Book> listNewBooks=bookDao.listNewBooks();
		
		assertEquals(4, listNewBooks.size());
	}
	
	@Test
	public void testCount() {
		
		long totalBooks=bookDao.count();
		assertEquals(2,totalBooks);
		
		
	}

}
