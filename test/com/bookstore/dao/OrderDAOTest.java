package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
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
		customer.setCustomerId(5);
		order.setCustomer(customer);
		
		order.setRecipientName("Priya Rawat");
		order.setRecipientPhone("798687576");
		order.setShippingAddress("Type-5/9-B");
		Set<OrderDetail> orderDetails=new HashSet<>();
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setBookOrder(order);
		Book book=new Book(7);
		orderDetail.setBook(book);
		orderDetail.setQuantity(3);
		orderDetail.setSubtotal(120.5f);
		
		
		orderDetails.add(orderDetail);
		
		order.setOrderDetails(orderDetails);
       BookOrder savedOrder=  orderDao.create(order);
       assertTrue(savedOrder !=null && savedOrder.getOrderDetails().size() >0);
         
	}

	@Test
	public void testCreateBookOrder2() {
		BookOrder order1=new BookOrder();
		Customer customer = new Customer();
		customer.setCustomerId(5);
		order1.setCustomer(customer);
		
		order1.setRecipientName("Preeti Rawat");
		order1.setRecipientPhone("9717962369");
		order1.setShippingAddress("Type-2/9-B");
		Set<OrderDetail> orderDetails=new HashSet<>();
		OrderDetail orderDetail1=new OrderDetail();
		orderDetail1.setBookOrder(order1);
		Book book1=new Book(7);
		orderDetail1.setBook(book1);
		orderDetail1.setQuantity(2);
		orderDetail1.setSubtotal(60.5f);
		
		
		orderDetails.add(orderDetail1);
		
		order1.setOrderDetails(orderDetails);
       BookOrder savedOrder=  orderDao.create(order1);
       assertTrue(savedOrder !=null && savedOrder.getOrderDetails().size() >0);
         
	}

	@Test
	public void testUpdateBookOrder() {
		Integer orderId=17;
		BookOrder order=orderDao.get(orderId);
		
		order.setRecipientName("Priyanka Sharma");
		order.setRecipientPhone("0087967564");
		order.setShippingAddress("Type-5/7-K");
		
		orderDao.update(order);
		
		BookOrder updateOrder=orderDao.get(orderId);
		
		assertTrue(updateOrder !=null && updateOrder.getOrderDetails().size() >0);
	
	}

	@Test
	public void testGet() {
		Integer orderId=16;
		BookOrder order=orderDao.get(orderId);
		System.out.println("RecipientName: " + order.getRecipientName());
		assertEquals(1,order.getOrderDetails().size());
	}

	@Test
	public void testDeleteObject() {
		int orderId=17;
		orderDao.delete(orderId);
		
		BookOrder order=orderDao.get(orderId);
		assertNull(order);
	}

	@Test
	public void testListAll() {
		List<BookOrder> listOrders=orderDao.listAll();
	
		assertTrue(listOrders.size()>0);
		
	}

	@Test
	public void testListByCustomerNoOrders() {
		Integer customerId=99;
		List<BookOrder> listOrders=orderDao.listByCustomer(customerId);
	
		assertTrue(listOrders.isEmpty());
		
	}
	@Test
	public void testListByCustomerHaveOrders() {
		Integer customerId=1;
		List<BookOrder> listOrders=orderDao.listByCustomer(customerId);
	
		assertTrue(listOrders.size()>0);
	
		
	}

	@Test
	public void testListByCustomerNull() {
		Integer customerId=10;
		Integer orderId=99;
		BookOrder order=orderDao.get(orderId, customerId);
	
		assertNull(order);
	
		
	}
	@Test
	public void testListByCustomerNotNull() {
		Integer customerId=6;
		Integer orderId=23;
		BookOrder order=orderDao.get(orderId, customerId);
	
		assertNotNull(order);
	
		
	}
	
	@Test
	public void testCount() {
		
		long totalOrder=orderDao.count();
		assertEquals(2,totalOrder);
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

}
