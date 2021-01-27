package com.bookstore.entity;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class BookRatingTest {

	@Test
	public void testAverageRating() {
         Book book=new Book();
         Set<Review> reviews =new HashSet<>();
         Review review1=new Review();
         review1.setRating(5);
         reviews.add(review1);
		book.setReviews(reviews );
		float averageRating = book.getAverageRating();
		
		assertEquals(5.0,averageRating,0.0);
	}

	@Test
	public void testRatingString1() {
         
		float averageRating = 0.0f;
		Book book=new Book();
		String actual=book.getRatingString(averageRating);
		
		String expected="off,off,off,off,off";
		
		assertEquals(expected,actual);
	}

	
}
