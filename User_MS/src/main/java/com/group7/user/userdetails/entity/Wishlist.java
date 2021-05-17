package com.group7.user.userdetails.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
public class Wishlist {
	@EmbeddedId
	private CompositeTable compositeId;

	public CompositeTable getCompositeId() {
		return compositeId;
	}

	public void setCompositeId(CompositeTable compositeId) {
		this.compositeId = compositeId;
	}
	
	
	
}
