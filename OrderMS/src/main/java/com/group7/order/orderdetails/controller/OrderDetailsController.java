package com.group7.order.orderdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.group7.order.orderdetails.dto.OrderDetailsDTO;
import com.group7.order.orderdetails.service.OrderDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	
	
/*	@PostMapping(value="/{prodId}")
	public ResponseEntity<String> placeOrder(@PathVariable String prodId) {

		try {
		String msg = orderDetailsService.placeOrder(prodId);
		return new ResponseEntity<String>(msg+" placed successfully",HttpStatus.OK);

		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	*/
	
	
	@GetMapping(value="/view/{orderId}")
	public ResponseEntity<OrderDetailsDTO> viewOrders(@PathVariable String orderId) throws Exception{

		 OrderDetailsDTO data=null;
		try {
			data = orderDetailsService.viewOrders(orderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(e.getMessage()), e);
		}
		return new ResponseEntity<OrderDetailsDTO>(data,HttpStatus.OK);

	}

	
	
}
