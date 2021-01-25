package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;

public class ReviewDAOTest extends BaseDAOTest{
	private static ReviewDAO reviewDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		reviewDao=new ReviewDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

	@Test
	public void testCreateReview() {
		Review review=new Review();
		Book book=new Book();
		book.setBookId(7);
		
		Customer customer=new Customer();
		customer.setCustomerId(5);
		
		review.setBook(book);
		review.setCustomer(customer);
		
		review.setHeadline("Book is nice");
		review.setRating(5);
		review.setComment("I've read this book.It is very good.");
	Review savedReview=reviewDao.create(review);
	assertTrue(savedReview.getReviewId()>0);
		
	}

	@Test
	public void testUpdateReview() {
		Review review=reviewDao.get(3);
		review.setHeadline("Book is excellent!");
		
		Review updatedReview=reviewDao.update(review);
		assertEquals(review.getHeadline(),updatedReview.getHeadline());
		
	}

	@Test
	public void testGet() {
		Review review=reviewDao.get(3);
		System.out.println("review: " + review.getComment());
		assertNotNull(review);
	}

	@Test
	public void testDeleteObject() {
		Integer reviewId=3;
		
		 reviewDao.delete(reviewId);
		 assertTrue(true);
	}

	@Test
	public void testListAll() {
		
		List<Review >review=reviewDao.listAll();
		for(Review listReview : review) {
			System.out.println("List of reviews: " + listReview.getBook().getTitle() + " having a customer :" 
								+ listReview.getCustomer().getFullname() 
								+ " with Rating: " + listReview.getRating());
		}
		assertTrue(!review.isEmpty());
		
	}

	@Test
	public void testCount() {
		long totalReviews=reviewDao.count();
		System.out.println("Total reviews are: " + totalReviews);
		assertTrue(totalReviews >0);
	}

}
