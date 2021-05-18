package com.group7.order.orderdetails.dto;

public class CartDTO {

	private String buyerId;
	private String prodId;
	private int quantity;
	private String compositeId;

	public String getCompositeId() {
		return compositeId;
	}
	public void setCompositeId(String compositeId) {
		this.compositeId = compositeId;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
