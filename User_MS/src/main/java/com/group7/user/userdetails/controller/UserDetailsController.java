package com.group7.user.userdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.group7.user.userdetails.dto.BuyerDTO;
import com.group7.user.userdetails.dto.SellerDTO;
import com.group7.user.userdetails.service.UserDetailsService;

@RestController
@RequestMapping(value="user")
public class UserDetailsController {

	@Autowired
	UserDetailsService userDetailsService;
	
	@PostMapping(value="/buyer/register")
	public ResponseEntity<String> registerBuyer(@RequestBody BuyerDTO buyer) {
		String id;
		try {
		id= userDetailsService.registerBuyerUser(buyer);
		return new ResponseEntity<String>(id+" Registered as a buyer successfully",HttpStatus.OK);

		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value="/seller/register")
	public ResponseEntity<String> registerSeller(@RequestBody SellerDTO sellerdto) {
		String id;
		try {
		id= userDetailsService.registerSellerUser(sellerdto);
		return new ResponseEntity<String>(id+" Registered as a seller successfully",HttpStatus.OK);
 
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/seller/login/{email}/{password}")
	public ResponseEntity<String> loginSeller(@PathVariable String email,@PathVariable String password) {
		String msg;
		try {
		msg= userDetailsService.loginSellerUser(email,password);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
 
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value="/buyer/login/{email}/{password}")
	public ResponseEntity<String> loginBuyer(@PathVariable String email,@PathVariable String password) {
		String msg;
		try {
		msg= userDetailsService.loginBuyerUser(email, password);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value="/buyer/{buyerId}")
	public ResponseEntity<String> DeleteBuyer(@PathVariable String buyerId) {
		String msg;
		try {
		msg= userDetailsService.deleteBuyer(buyerId);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
 
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value="/seller/{sellerId}")
	public ResponseEntity<String> DeleteSeller(@PathVariable String sellerId) {
		String msg;
		try {
		msg= userDetailsService.deleteSeller(sellerId);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
 
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/cart")
	public ResponseEntity<String> DemoCart() {
	
		try {
		userDetailsService.demoCart();
		return new ResponseEntity<String>("Successly added in cart",HttpStatus.OK);
 
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
}
