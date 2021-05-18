package com.group7.product.productdetails.contoller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.group7.product.productdetails.dto.ProductDTO;
import com.group7.product.productdetails.service.ProductDetailsService;
//api class
@RestController
@RequestMapping(value="product")
public class ProductDetailsController {

	@Autowired
	ProductDetailsService productDetailsService;
	
	@Autowired
	Environment environment;
	
	@PostMapping(value="/add")
	public ResponseEntity<String> addProduct(@RequestBody ProductDTO productdto) {

		try {
		String msg = productDetailsService.addProduct(productdto);
		return new ResponseEntity<String>(msg+" added successfully",HttpStatus.OK);

		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value="/delete/{prodId}")
	public ResponseEntity<String> deleteProduct(@PathVariable String prodId) {

		try {
		String msg = productDetailsService.deleteProduct(prodId);
		return new ResponseEntity<String>(msg+" deleted successfully",HttpStatus.OK);

		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/search/{productName}")
	public ResponseEntity<ProductDTO> searchProductByName(@PathVariable String productName) throws Exception{

		 ProductDTO data=null;
		try {
			data = productDetailsService.CartProductName(productName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(e.getMessage()), e);
		}
		return new ResponseEntity<ProductDTO>(data,HttpStatus.OK);

	}
	
	@GetMapping(value="/searchby/{category}")
	public ResponseEntity<List<ProductDTO>> searchProductByCategory(@PathVariable String category) {

		 List<ProductDTO> data=new ArrayList<>();
		try {
			data=productDetailsService.CartCategory(category);
			return new ResponseEntity<>(data,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()));		}
	

	}

}
