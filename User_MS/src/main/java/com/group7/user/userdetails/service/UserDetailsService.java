package com.group7.user.userdetails.service;

import org.springframework.stereotype.Service;

import com.group7.user.userdetails.dto.BuyerDTO;
import com.group7.user.userdetails.dto.CartDTO;
import com.group7.user.userdetails.dto.SellerDTO;
import com.group7.user.userdetails.dto.WishlistDTO;

@Service(value="userDetailsService")
public interface UserDetailsService {

	public String registerBuyerUser(BuyerDTO buyerdto);
	public String registerSellerUser(SellerDTO buyerdto);

	public String loginSellerUser(String email, String password)  throws Exception ;
	public String loginBuyerUser(String email, String password) throws Exception;
	
	public String deleteBuyer(String buyerId) throws Exception;
	public String deleteSeller(String sellerId) throws Exception;
	void demoCart();
	
	public void createBuyerList(WishlistDTO wishlistDTO);
	public WishlistDTO wishlistData(String buyerId,String productName);

	public String wishToCart(CartDTO cartDTO) throws Exception;
	public CartDTO cartData(String buyerId,String prodId,int quantity);

}
