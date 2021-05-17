package com.group7.user.userdetails.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group7.user.userdetails.dto.BuyerDTO;
import com.group7.user.userdetails.dto.SellerDTO;
import com.group7.user.userdetails.entity.Buyer;
import com.group7.user.userdetails.entity.Cart;
import com.group7.user.userdetails.entity.CompositeTable;
import com.group7.user.userdetails.entity.Seller;
import com.group7.user.userdetails.repository.CartRepository;
import com.group7.user.userdetails.repository.SellerRepository;
import com.group7.user.userdetails.repository.UserDetailsRepository;

@Service("userDetailsServiceImpl")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	Validator validator;
	
	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Autowired
	SellerRepository sellerRepository;

	@Autowired
	CartRepository cartRepository;
	@Override
	public String registerBuyerUser(BuyerDTO buyerdto) {
		// TODO Auto-generated method stub
	//	System.out.println(validator.validateBuyer(buyerdto));
		if(validator.validateBuyer(buyerdto)) {
		Buyer buyer=new Buyer();
		buyer.setBuyerId(buyerdto.getBuyerId());
		buyer.setEmail(buyerdto.getEmail());
		buyer.setName(buyerdto.getName());
		buyer.setPassword(buyerdto.getPassword());
		buyer.setIsActive(buyerdto.getIsActive());
		buyer.setPhoneNumber(buyerdto.getPhoneNumber());
		buyer.setIsPiviledged( buyerdto.getIsPiviledged());
		buyer.setRewardPoints(buyerdto.getRewardPoints());
		System.out.println(userDetailsRepository.save(buyer));
		return buyer.getBuyerId();}
		else return null;
		}

	@Override
	public String registerSellerUser(SellerDTO sellerdto) {
		// TODO Auto-generated method stub
		if(validator.validateSeller(sellerdto))
		{
		Seller seller= new Seller();
		seller.setSellerId(sellerdto.getSellerId());
		seller.setEmail(sellerdto.getEmail());
		seller.setName(sellerdto.getName());
		seller.setIsActive(sellerdto.getIsActive());
		seller.setPassword(sellerdto.getPassword());
		seller.setPhoneNumber(sellerdto.getPhoneNumber());
		sellerRepository.save(seller);
		return seller.getSellerId();}
		else 
			return null;
	}

	@Override
	public String loginBuyerUser(String email,String password) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(email);
		Optional<Buyer> emailId = userDetailsRepository.findByEmail(email);
		
		if(emailId.isEmpty()) {
			throw new Exception("No buyer with such email exists"); 
		}
		if(emailId.get().getPassword().equals(password)) {
		BuyerDTO buyerdto=new BuyerDTO();
		buyerdto.setEmail(email);
		buyerdto.setPassword(password);
		buyerdto.setIsActive("yes");
		return "Successfully logged in";}
		else
			return "login unsuccessful";

	}

	@Override
	public String loginSellerUser(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(email);
		Optional<Seller> emailSeller = sellerRepository.findByEmail(email);
		if(emailSeller.isEmpty())
			throw new Exception("No seller with such email exists"); 
		if(emailSeller.get().getPassword().equals(password)) {
		SellerDTO sellerdto=new SellerDTO();
		sellerdto.setEmail(email);
		sellerdto.setPassword(password);
		sellerdto.setIsActive("yes");
		return "Successfully logged in";}else
			return "login unsuccessful";

	}

	@Override
	public String deleteBuyer(String buyerId) throws Exception {
		// TODO Auto-generated method stub
		Optional<Buyer> buyerDelete = userDetailsRepository.findById(buyerId);
		if(buyerDelete.isEmpty())
			throw new Exception("No buyer with such buyerId exists"); 
		userDetailsRepository.deleteById(buyerId);
		
		return "Deleted successfully";
	}

	@Override
	public String deleteSeller(String sellerId) throws Exception {
		// TODO Auto-generated method stub
		Optional<Seller> deleteSeller = sellerRepository.findById(sellerId);
		if(deleteSeller.isEmpty())
			throw new Exception("No seller with such sellerId exists"); 
		sellerRepository.deleteById(sellerId);
		return "Deleted successfully";
	}
	
	
	@Override
	public void demoCart() {
		Cart c=new Cart();
		CompositeTable ct=new CompositeTable();
		ct.setBuyerId("B102");
		ct.setProdId("P102");
		c.setCompositeId(ct);
		c.setQuantity(100);
		cartRepository.save(c);
	}

}
