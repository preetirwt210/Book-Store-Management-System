package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Category;

public class CategoryDAOTest extends BaseDAOTest{
	
	
	private  static CategoryDAO categoryDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
	      categoryDao= new CategoryDAO(entityManager);
	}

	
	@Test
	public void testCreateCategory() {
		Category newCategory=new Category("Java");
		Category category=categoryDao.create(newCategory);
		
		assertTrue(category != null && category.getCategoryId() >0);
		
	}

	@Test
	public void testUpdateCategory() {
		
		Category cat=new Category("Python");
		
		cat.setCategoryId(5);
		Category category=categoryDao.update(cat);
		
		assertEquals(cat.getName(),category.getName());
		
	}

	@Test
	public void testGet() {
		
		Integer catId=2;
		Category cat=categoryDao.get(catId);
		
		assertNotNull(cat);
	}

	@Test
	public void testDeleteObject() {
		
		Integer catId=3;
		categoryDao.delete(catId);
		
		Category cat=categoryDao.get(catId);
		assertNull(cat);
	}

	@Test
	public void testListAll() {
		List<Category> listCategory= categoryDao.listAll();
		
		assertTrue(listCategory.size()>0);
	}

	@Test
	public void testCount() {
		
		long totalCategories=categoryDao.count();
		assertEquals(4,totalCategories);
	}
	
	@Test
	public void testFindByName() {
		
		String name="Core Java";
		Category category=categoryDao.findByName(name);
		assertNotNull(category);
	}
	
	@Test
	public void testFindByNameNotFound() {
		
		String name="Core Java1";
		Category category=categoryDao.findByName(name);
		assertNull(category);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		 BaseDAOTest.tearDownAfterClass();
	}

}
