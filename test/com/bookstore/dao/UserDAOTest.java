package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDao;
	
	@BeforeClass
	public static void setUpClass() {
		
		 entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		 entityManager =entityManagerFactory.createEntityManager();
		 userDao= new UserDAO(entityManager);
	}
	
	@Test
	public void testCreateUsers() {
		Users user1= new Users();
		user1.setEmail("tommy@gmail.com");
		user1.setFullName("tommy Warner");
		user1.setPassword("password12356");
		
	      user1= userDao.create(user1);
	      
	       assertTrue(user1.getUserId()>0);

	}
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1= new Users();
		  user1= userDao.create(user1);
	 }
	
	@Test
	public void testUpdateUsers() {
		Users user= new Users();
		 user.setUserId(2);
		 user.setEmail("willian@gmail.com");
		 user.setFullName("william Son");
		 user.setPassword("HappyMe");
		 
		 user=userDao.update(user);
		 String expected= "HappyMe";
		 String actual= user.getPassword();
	
		 assertEquals(expected,actual);
	}
	
	
	@AfterClass
	public static void tearDownClass() {
		
		 entityManager.close();
	       entityManagerFactory.close();
	}

}
