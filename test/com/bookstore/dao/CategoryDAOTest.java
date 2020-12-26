package com.bookstore.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Category;

public class CategoryDAOTest {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private  static CategoryDAO categoryDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		 entityManager =entityManagerFactory.createEntityManager();
	      categoryDao= new CategoryDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		 entityManager.close();
	       entityManagerFactory.close();
	}

	@Test
	public void testCreateCategory() {
		Category newCategory=new Category("Java");
		Category category=categoryDao.create(newCategory);
		assertTrue(category != null && category.getCategoryId() >0);
	}

	@Test
	public void testUpdateCategory() {
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
