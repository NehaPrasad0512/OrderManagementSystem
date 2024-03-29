package com.group7.product.productdetails.dto;

import com.group7.product.productdetails.entity.CompositeTable;
import com.group7.product.productdetails.entity.SubscribedProduct;

public class SubscribedProductDTO {

	private String buyerId;
	private String prodId;
	private String sellerId;
	private int quantity;
	
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
	
	public static SubscribedProductDTO valueOf(SubscribedProduct subscribedProduct) {
		SubscribedProduct subProd=new SubscribedProduct();
		CompositeTable ct=new CompositeTable();
		ct.setBuyerId(subscribedProduct.getCompositetb().getBuyerId());
		ct.setProdid(subscribedProduct.getCompositetb().getProdid());
		subProd.setCompositetb(ct);
		subProd.setQuantity(subscribedProduct.getQuantity());
		subProd.setSellerId(subscribedProduct.getSellerId());
		return null;
	}
	
	
}
