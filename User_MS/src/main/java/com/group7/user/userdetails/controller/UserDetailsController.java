package com.group7.user.userdetails.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.group7.user.userdetails.dto.BuyerDTO;
import com.group7.user.userdetails.dto.CartDTO;
import com.group7.user.userdetails.dto.ProductDTO;
import com.group7.user.userdetails.dto.SellerDTO;
import com.group7.user.userdetails.dto.WishlistDTO;
import com.group7.user.userdetails.repository.WishlistRepository;
import com.group7.user.userdetails.service.UserDetailsService;

@RestController
@RequestMapping(value="user")
public class UserDetailsController {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	Environment environment;
	@Autowired
	WishlistRepository wishlistRepository;

	 @Autowired 
	 DiscoveryClient client;
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

	@PostMapping(value="/removeItemsCart/{buyerId}/{prodId}")
	public ResponseEntity<String> DeleteBuyer(@PathVariable String buyerId,@PathVariable String prodId) {
		String msg;
		try {
		msg=userDetailsService.deleteFromCart(prodId, buyerId);
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
		
		return new ResponseEntity<String>("Successfully added in cart",HttpStatus.OK);
 
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/buyer/wishlist/{buyerId}/{productName}")
	public WishlistDTO getWishlistProduct(@PathVariable String buyerId,@PathVariable String productName) {
	ProductDTO productId = new RestTemplate().getForObject("http://localhost:8400/product/wishlist/"+productName, ProductDTO.class);
	WishlistDTO value = userDetailsService.wishlistData(buyerId,productId.getProdID());
	return value;		
	
	}

	@PostMapping(value="/buyer/wish-cart")
	public ResponseEntity<String> getWishlistToCart(@RequestBody CartDTO cartDTO) {
		try {
		userDetailsService.wishToCart(cartDTO);
		
		return new ResponseEntity<String>("Successfully added product from wishlist to cart",HttpStatus.OK);
 
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping(value="/buyer/cart/{buyerId}/{productName}/{quantity}")
	public CartDTO addCartProduct(@PathVariable String buyerId,@PathVariable String productName,@PathVariable int quantity) {
	ProductDTO productId = new RestTemplate().getForObject("http://localhost:8400/product/wishlist/"+productName, ProductDTO.class);
	System.out.println(productId.getProdID());
	
		CartDTO value = userDetailsService.cartData(buyerId,productId.getProdID(),quantity);
		return value;		
	
	}
	
	@PostMapping(value="/buyer/wishlist/{buyerId}/{productName}")
	public WishlistDTO addCartProduct(@PathVariable String buyerId,@PathVariable String productName) {
	ProductDTO productId = new RestTemplate().getForObject("http://localhost:8400/product/wishlist/"+productName, ProductDTO.class);
	System.out.println(productId.getProdID());
		WishlistDTO value = userDetailsService.wishlistData(buyerId, productId.getProdID());
		return value;		
	
	}

	@GetMapping(value="/cart")
	public ResponseEntity<List<CartDTO>> viewCart() {
		 List<CartDTO> data=new ArrayList<>();
			try {
				data=userDetailsService.viewAllCart();

				return new ResponseEntity<>(data,HttpStatus.OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()));		}

	}
}
