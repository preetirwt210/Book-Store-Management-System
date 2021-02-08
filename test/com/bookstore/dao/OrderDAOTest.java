package com.bookstore.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;

public class OrderDAOTest extends BaseDAOTest {

	private static OrderDAO orderDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		orderDao=new OrderDAO(entityManager);
	}

	

	@Test
	public void testCreateBookOrder() {
		BookOrder order=new BookOrder();
		Customer customer = new Customer();
		customer.setCustomerId(1);
		order.setCustomer(customer);
		
		order.setRecipientName("Preeti Rawat");
		order.setRecipientPhone("9717962369");
		order.setShippingAddress("Type-2/9-B");
		Set<OrderDetail> orderDetails=new HashSet<>();
		OrderDetail orderDetail=new OrderDetail();
		
		Book book=new Book(4);
		orderDetail.setBook(book);
		orderDetail.setQuantity(2);
		orderDetail.setSubtotal(60.5f);
		
		
		orderDetails.add(orderDetail);
		
		order.setOrderDetails(orderDetails);
       BookOrder savedOrder=  orderDao.create(order);
       assertTrue(savedOrder !=null && savedOrder.getOrderDetails().size() >0);
         
	}

	@Test
	public void testUpdateBookOrder() {
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
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

}
