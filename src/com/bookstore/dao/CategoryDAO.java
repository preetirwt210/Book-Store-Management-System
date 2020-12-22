package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
		
	}
   
	public Category create(Category category) {
		return null;
}


       public Category update(Category t) {

	     return null;
}
	
	@Override
	public Category get(Object id) {
		
		return null;
	}

	@Override
	public void delete(Object id) {
		
		
	}

	@Override
	public List<Category> listAll() {
		
		return null;
	}

	@Override
	public long count() {
		
		return 0;
	}

}
