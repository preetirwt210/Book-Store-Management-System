package com.bookstore.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;

public class UsersTest {

	public static void main(String[] args) {
		Users user1= new Users();
		user1.setEmail("Kriya@gmail.com");
		user1.setFullName("Kriya rawat");
		user1.setPassword("password");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		
	       entityManager.getTransaction().begin();
	       
	       entityManager.persist(user1);
	       
	       entityManager.getTransaction().commit();
	       entityManager.close();
	       entityManagerFactory.close();
	       
	       System.out.println(user1 + " object was persisted");
	}
	
	

}
