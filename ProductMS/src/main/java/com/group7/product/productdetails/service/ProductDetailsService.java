package com.group7.product.productdetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group7.product.productdetails.dto.ProductDTO;

@Service
public interface ProductDetailsService {

	public String addProduct(ProductDTO productdto) throws Exception;
	
	public String deleteProduct(String productName) throws Exception;
	
	
	public List<ProductDTO> CartCategory(String category) throws Exception;
	
	public ProductDTO CartProductName(String productName) throws Exception;
	
	public ProductDTO getSpecificProduct(String productName);

}
