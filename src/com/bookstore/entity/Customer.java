package com.bookstore.entity;
// Generated Dec 14, 2020, 4:00:07 PM by Hibernate Tools 5.4.21.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Customer generated by hbm2java
 */
public class Customer implements java.io.Serializable {

	private Integer customerId;
	private String email;
	private String fullName;
	private String address;
	private String city;
	private String country;
	private String phone;
	private String zipcode;
	private String password;
	private Date registerDate;
	private Set reviews = new HashSet(0);
	private Set bookOrders = new HashSet(0);

	public Customer() {
	}

	public Customer(String email, String fullName, String address, String city, String country, String phone,
			String zipcode, String password, Date registerDate) {
		this.email = email;
		this.fullName = fullName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.zipcode = zipcode;
		this.password = password;
		this.registerDate = registerDate;
	}

	public Customer(String email, String fullName, String address, String city, String country, String phone,
			String zipcode, String password, Date registerDate, Set reviews, Set bookOrders) {
		this.email = email;
		this.fullName = fullName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.zipcode = zipcode;
		this.password = password;
		this.registerDate = registerDate;
		this.reviews = reviews;
		this.bookOrders = bookOrders;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Set getReviews() {
		return this.reviews;
	}

	public void setReviews(Set reviews) {
		this.reviews = reviews;
	}

	public Set getBookOrders() {
		return this.bookOrders;
	}

	public void setBookOrders(Set bookOrders) {
		this.bookOrders = bookOrders;
	}

}
