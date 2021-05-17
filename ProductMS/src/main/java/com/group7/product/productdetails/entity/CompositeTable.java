package com.group7.product.productdetails.entity;

import java.io.Serializable;

public class CompositeTable implements Serializable{
	
	protected String buyerId;
	protected String prodid;
	
	
	public CompositeTable() {
		super();
	}
	public CompositeTable(String buyerId, String prodid) {
		super();
		this.buyerId = buyerId;
		this.prodid = prodid;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buyerId == null) ? 0 : buyerId.hashCode());
		result = prime * result + ((prodid == null) ? 0 : prodid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeTable other = (CompositeTable) obj;
		if (buyerId == null) {
			if (other.buyerId != null)
				return false;
		} else if (!buyerId.equals(other.buyerId))
			return false;
		if (prodid == null) {
			if (other.prodid != null)
				return false;
		} else if (!prodid.equals(other.prodid))
			return false;
		return true;
	}
	
	
}
