package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest extends BaseDAOTest {
	
	
	private static UserDAO userDao;
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		
		BaseDAOTest.setUpBeforeClass();
		 userDao= new UserDAO(entityManager);
	}
	
	@Test
	public void testCreateUsers() {
		Users user1= new Users();
		user1.setEmail("tommy3@gmail.com");
		user1.setFullName("tommy S Warner");
		user1.setPassword("password1356");
		
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
		//Users user= new Users();
		 //user.setUserId(2);
		 //user.setEmail("willian@gmail.com");
		 //user.setFullName("william Son");
		 //user.setPassword("HappyMe");
		 
		 //user=userDao.update(user);
		 //String expected= "HappyMe";
		 //String actual= user.getPassword();
	
		 //assertEquals(expected,actual);
	}
	
	
	@Test
	public void testGetUsersFound() {
		Integer userId = 2;
		Users user= userDao.get(userId);
		System.out.println(user.getEmail());
		if(user != null) {
		 System.out.println(user.getEmail());
		}
		assertNotNull(user);
	}
	

	@Test
	public void testDeleteUsers() {
		Integer userId =12;
		userDao.delete(userId);
		
		Users user= userDao.get(userId);
		
		 assertNull(user);
		
		
	}
	@Test(expected=Exception.class)
	public void testDeleteNonExistUsers() {
		Integer userId =16;
		userDao.delete(userId);
		
		Users user= userDao.get(userId);
		
		 assertNotNull(user);
		}
	
	@Test
	public void testListAll() {
		List<Users> listUsers= userDao.listAll();
		for(Users user: listUsers)
			System.out.println(user.getEmail());
		assertTrue(listUsers.size()>0);
	}
	
	
	@Test
	public void testCount() {
		long totalUsers = userDao.count();
		assertEquals(11,totalUsers);
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email="preetirawat711@gmail.com";
		String password="rwtpreeti210";
		boolean loginResult= userDao.checkLogin(email, password);
		
		assertTrue(loginResult);
	}
	@Test
	public void testFindByEmail() {
		String email ="sneha@gmail.com";
	      Users user= userDao.findByEmail(email);
		assertNotNull(user);
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		
		 BaseDAOTest.tearDownAfterClass();
	}

}
