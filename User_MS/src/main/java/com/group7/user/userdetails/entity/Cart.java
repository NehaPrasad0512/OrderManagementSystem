package com.group7.user.userdetails.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart{
	@EmbeddedId
	private CompositeTable compositeId;
	
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public CompositeTable getCompositeId() {
		return compositeId;
	}

	public void setCompositeId(CompositeTable compositeId) {
		this.compositeId = compositeId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
