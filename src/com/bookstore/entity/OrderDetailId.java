package com.bookstore.entity;
// Generated Dec 14, 2020, 4:00:07 PM by Hibernate Tools 5.4.21.Final

/**
 * OrderDetailId generated by hbm2java
 */
public class OrderDetailId implements java.io.Serializable {

	private int orderId;
	private Integer bookId;
	private Integer quantity;
	private Float subtotal;

	public OrderDetailId() {
	}

	public OrderDetailId(int orderId) {
		this.orderId = orderId;
	}

	public OrderDetailId(int orderId, Integer bookId, Integer quantity, Float subtotal) {
		this.orderId = orderId;
		this.bookId = bookId;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderDetailId))
			return false;
		OrderDetailId castOther = (OrderDetailId) other;

		return (this.getOrderId() == castOther.getOrderId())
				&& ((this.getBookId() == castOther.getBookId()) || (this.getBookId() != null
						&& castOther.getBookId() != null && this.getBookId().equals(castOther.getBookId())))
				&& ((this.getQuantity() == castOther.getQuantity()) || (this.getQuantity() != null
						&& castOther.getQuantity() != null && this.getQuantity().equals(castOther.getQuantity())))
				&& ((this.getSubtotal() == castOther.getSubtotal()) || (this.getSubtotal() != null
						&& castOther.getSubtotal() != null && this.getSubtotal().equals(castOther.getSubtotal())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOrderId();
		result = 37 * result + (getBookId() == null ? 0 : this.getBookId().hashCode());
		result = 37 * result + (getQuantity() == null ? 0 : this.getQuantity().hashCode());
		result = 37 * result + (getSubtotal() == null ? 0 : this.getSubtotal().hashCode());
		return result;
	}

}
