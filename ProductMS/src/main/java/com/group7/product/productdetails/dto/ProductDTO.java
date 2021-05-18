package com.group7.product.productdetails.dto;

import java.util.Optional;

import com.group7.product.productdetails.entity.Product;

public class ProductDTO {
	private String prodId;
	private String productName;
	private float price;
	private int stock;
	private String description;
	private String image;
	private String sellerId;
	private String category;
	private String subcategory;
	private float productRating;
	public String getProdID() {
		return prodId;
	}
	public void setProdID(String prodId) {
		this.prodId = prodId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public float getProductRating() {
		return productRating;
	}
	public void setProductRating(float productRating) {
		this.productRating = productRating;
	}
	
	//Converts an entity into DTO
	public static ProductDTO valueOf(Optional<Product> product) {
		ProductDTO productDTO=new ProductDTO();
		productDTO.setProdID(product.get().getProdID());
		productDTO.setCategory(product.get().getCategory());
		productDTO.setDescription(product.get().getDescription());
		productDTO.setImage(product.get().getImage());
		productDTO.setPrice(product.get().getPrice());
		productDTO.setProductName(product.get().getProductName());
		productDTO.setSubcategory(product.get().getSubcategory());
		productDTO.setStock(product.get().getStock());
		productDTO.setSellerId(product.get().getSellerId());
		productDTO.setProductRating(product.get().getProductRating());
		return productDTO;
	}
}
