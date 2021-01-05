package com.bookstore.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public void testUpdateBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testListAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

}
