package com.group7.order.orderdetails.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.group7.order.orderdetails.dto.CartDTO;
import com.group7.order.orderdetails.dto.OrderDetailsDTO;
import com.group7.order.orderdetails.dto.ProductDTO;
import com.group7.order.orderdetails.service.OrderDetailsService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value="order")
public class OrderDetailsController {
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@Autowired
	Environment environment;
	
	@PostMapping(value="/add")
	public ResponseEntity<String> addProductToCart(@RequestBody OrderDetailsDTO orderdto) {

		try {
		String msg = orderDetailsService.addProductToCart(orderdto);
		return new ResponseEntity<String>(msg+" added successfully",HttpStatus.OK);

		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/delete/{prodId}")
	public ResponseEntity<String> deleteProductFromCart(@PathVariable String prodId) {

		try {
		String msg = orderDetailsService.deleteProductFromCart(prodId);
		return new ResponseEntity<String>(msg+" deleted successfully",HttpStatus.OK);

		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping(value="/placeOrder")
	public ResponseEntity<String> placeOrder() {

		try {
		List cartItem = new RestTemplate().getForObject("http://localhost:8200/user/cart",List.class);
		ObjectMapper mapper = new ObjectMapper();
		if(!cartItem.isEmpty())
		{
		 CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, CartDTO.class);

		List<CartDTO> item= mapper.convertValue(cartItem,listType);
		
		List<String> val = orderDetailsService.placeOrder(item);
		
		return new ResponseEntity<String>(val+" placed successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("no items to place",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
	@GetMapping(value="/view")
	public ResponseEntity<List<OrderDetailsDTO>> viewOrders() throws Exception{

		 List<OrderDetailsDTO> data=null;
		try {
			data = orderDetailsService.viewAllOrders();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(e.getMessage()), e);
		}
		return new ResponseEntity<List<OrderDetailsDTO>>(data,HttpStatus.OK);

	}

	@GetMapping(value="/prodId}")
	public ResponseEntity<ProductDTO> viewOrders(@PathVariable String prodId) throws Exception{

		 ProductDTO data=null;
		try {
			data = orderDetailsService.getProduct();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(e.getMessage()), e);
		}
		return new ResponseEntity<ProductDTO>(data,HttpStatus.OK);

	}
	
	
}
