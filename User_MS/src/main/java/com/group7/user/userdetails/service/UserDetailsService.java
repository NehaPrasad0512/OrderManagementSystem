package com.group7.user.userdetails.service;

import org.springframework.stereotype.Service;

import com.group7.user.userdetails.dto.BuyerDTO;
import com.group7.user.userdetails.dto.SellerDTO;
import com.group7.user.userdetails.entity.Buyer;
import com.group7.user.userdetails.entity.Seller;

@Service(value="userDetailsService")
public interface UserDetailsService {

	public String registerBuyerUser(BuyerDTO buyerdto);
	public String registerSellerUser(SellerDTO buyerdto);

	public String loginSellerUser(String email, String password)  throws Exception ;
	public String loginBuyerUser(String email, String password) throws Exception;
	
	public String deleteBuyer(String buyerId) throws Exception;
	public String deleteSeller(String sellerId) throws Exception;
	void demoCart();
	
	
}
