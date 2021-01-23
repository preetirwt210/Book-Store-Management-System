package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Customer;

public class CustomerDAOTest extends BaseDAOTest{

	private static CustomerDAO customerDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		customerDao=new CustomerDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

	@Test
	public void testCreateCustomer() {
		Customer customer=new Customer();
		customer.setEmail("priyarawat95@gmail.com");
		customer.setFullname("Priya Rawat");
		customer.setCity("RawatBhata");
		customer.setCountry("India");
		customer.setAddress("Type-2/9/B");
		customer.setPassword("priyarwt");
		customer.setPhone("9717965555");
		customer.setZipcode("323307");
		
		Customer savedCustomer=customerDao.create(customer);
		assertTrue(savedCustomer.getCustomerId()>0);
		
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer=customerDao.get(2);
		String email="priyarwt95@gmail.com";
		customer.setEmail(email);
		Customer updatedCustomer=customerDao.update(customer);
		
		assertTrue(updatedCustomer.getEmail().equals(email));
	}

	@Test
	public void testGet() {
		Integer customerId=1;
		Customer customer=customerDao.get(customerId);
		
		assertNotNull(customer);
	}

	@Test
	public void testDeleteObject() {
		Integer customerId=2;
		customerDao.delete(customerId);
		Customer customer=customerDao.get(2);
		assertNull(customer);
	}

	@Test
	public void testListAll() {
		List<Customer> listCustomers=customerDao.listAll();
		for(Customer customer:listCustomers) {
			System.out.println(customer.getFullname());
		}
		assertTrue(listCustomers.size()>0);
	}

	@Test
	public void testCount() {
		long totalCustomers=customerDao.count();
		assertEquals(1,totalCustomers);
	}
	@Test
	public void testFindByEmail() {
		String email="preetirawat711@gmail.com";
		Customer customer=customerDao.findByEmail(email);
		assertNotNull(customer);
	}
	@Test
	public void testCheckLoginSuccess() {
		String email="preetirawat711@gmail.com";
		String password="rwtpreeti210";
		Customer customer=customerDao.checkLogin(email, password);
		assertNotNull(customer);
	}

}
