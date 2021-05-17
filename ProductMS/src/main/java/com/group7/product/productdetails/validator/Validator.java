package com.group7.product.productdetails.validator;

import com.group7.product.productdetails.dto.ProductDTO;

public class Validator {

	public static boolean ValidateProduct(ProductDTO productdto) throws Exception {
		if(!ValidateName(productdto.getProductName()))
			throw new Exception("Product Name is invalid");
		else if(!ValidatePrice(productdto.getPrice()))
			throw new Exception("Product Price should be minimum 200");
		else if(!ValidateStock(productdto.getStock()))
			throw new Exception("Product stock should be minimum 10");
		else if(!ValidateImage(productdto.getImage()))
			throw new Exception("Product Image format is invalid");
		else if(!ValidateDescription(productdto.getDescription()))
			throw new Exception("Product Descriptionshould be minimum 500");
	
		return true;
	}
	
	public static boolean ValidateName(String productName) {
		String regrex="^([A-Za-z]+([ ][A-Za-z]+)*){1,100}$";
		if(productName.matches(regrex))
			return true;
	
		return false;
	}
	
	public static boolean ValidateDescription(String description) {
		String regrex="^([A-Za-z ]+){1,500}$";
		if(description.matches(regrex))
			return true;
		return false;
	}
	
	public static boolean ValidatePrice(float price) {
		if(price>=200)
			return true;
		return false;
	}
	
	public static boolean ValidateStock(int stock) {
		if(stock>=10)
			return true;
		return false;
	}
	
	public static boolean ValidateImage(String image) {
		String regrex="^[A-Za-z0-9]+(.jpeg|.png)$";
		if(image.matches(regrex))
			return true;
		
		return false;
	}
	
}
