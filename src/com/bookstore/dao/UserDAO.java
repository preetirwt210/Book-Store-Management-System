package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	
	public Users create(Users user) {
				return super.create(user);
	}


	@Override
	public Users update(Users user) {
		// TODO Auto-generated method stub
		return super.update(user);
	}

	@Override
	public Users get(Object userId) {
		// TODO Auto-generated method stub
		return super.find(Users.class, userId);
	}
	
	public Users findByEmail(String email) {
		List<Users> listUsers= super.findWithNameQuery("Users.findByEmail", "email", email);
		if(listUsers != null && listUsers.size()>0) {
			return listUsers.get(0);
		}
		return null;
		
	}

	@Override
	public void delete(Object userId) {
		 super.delete(Users.class,userId);
	}

	@Override
	public List<Users> listAll() {
		// TODO Auto-generated method stub
		return super.findWithNameQuery("Users.findAll");
	}

	@Override
	public long count() {
		
		return super.countWithNameQuery("Users.countAll");
	}

	
}
