package com.group7.order.orderdetails.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="productOrdered")
public class ProductOrdered {
	
	@EmbeddedId
	private CompositeTable compositetb;
	private String sellerId;
	private int quantity;
	
	public ProductOrdered() {
		super();
	}
	
	public ProductOrdered(CompositeTable compositetb, String sellerId, int quantity) {
		super();
		this.compositetb = compositetb;
		this.sellerId = sellerId;
		this.quantity = quantity;
	}

	public CompositeTable getCompositetb() {
		return compositetb;
	}

	public void setCompositetb(CompositeTable compositetb) {
		this.compositetb = compositetb;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
