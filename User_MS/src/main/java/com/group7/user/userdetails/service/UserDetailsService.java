package com.group7.user.userdetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group7.user.userdetails.dto.BuyerDTO;
import com.group7.user.userdetails.dto.CartDTO;
import com.group7.user.userdetails.dto.LoginDTO;
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
	public void demoCart();
	
	public void createBuyerList(WishlistDTO wishlistDTO);
	public WishlistDTO wishlistData(String buyerId,String productName);

	public String wishToCart(CartDTO cartDTO) throws Exception;
	public CartDTO cartData(String buyerId,String prodId,int quantity);

	public String deleteFromCart(String prodId,String buyerId);
	
	public List<CartDTO> viewAllCart() throws Exception;
	public String loginSeller(LoginDTO login) throws Exception;
	public String loginBuyer(LoginDTO loginDTO) throws Exception;
}
