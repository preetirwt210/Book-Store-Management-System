package com.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries( { @NamedQuery(name = "Users.findAll",
                query = "SELECT u FROM Users u ORDER BY u.fullName") ,
	             @NamedQuery(name = "Users.countAll",
	             query = "SELECT Count(u) FROM Users u"),
	             @NamedQuery(name="Users.findByEmail" , 
	             query="SELECT u FROM Users u WHERE u.email= : email"),
				@NamedQuery(name="Users.checkLogin" , 
				query="SELECT u FROM Users u WHERE u.email= :email AND password= :password")
				})
@Table(name="users")
public class Users {
	
	public Users() {}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="password")
	private String password;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Users(String email, String fullName, String password) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}

	public Users(Integer userId, String email, String fullName, String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}

		
	

}
