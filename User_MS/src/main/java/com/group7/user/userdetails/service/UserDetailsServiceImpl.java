package com.group7.user.userdetails.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group7.user.userdetails.dto.BuyerDTO;
import com.group7.user.userdetails.dto.CartDTO;
import com.group7.user.userdetails.dto.SellerDTO;
import com.group7.user.userdetails.dto.WishlistDTO;
import com.group7.user.userdetails.entity.Buyer;
import com.group7.user.userdetails.entity.Cart;
import com.group7.user.userdetails.entity.CompositeTable;
import com.group7.user.userdetails.entity.Seller;
import com.group7.user.userdetails.entity.Wishlist;
import com.group7.user.userdetails.repository.CartRepository;
import com.group7.user.userdetails.repository.SellerRepository;
import com.group7.user.userdetails.repository.UserDetailsRepository;
import com.group7.user.userdetails.repository.WishlistRepository;

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
	WishlistRepository wishlistRepository;

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
		ct.setProdId("P102");
		c.setCompositeId(ct);
		c.setQuantity(100);
		cartRepository.save(c);
	}

	@Override
	public WishlistDTO wishlistData(String buyerId,String prodId) {
		// TODO Auto-generated method stub
		Wishlist wishlist=new Wishlist();
		CompositeTable ct=new CompositeTable();
		ct.setBuyerId(buyerId);
		ct.setProdId(prodId);
		wishlist.setCompositeId(ct);
		wishlistRepository.save(wishlist);
		WishlistDTO wishDTO=new WishlistDTO();
		wishDTO.setBuyerId(wishlist.getCompositeId().getBuyerId());
		wishDTO.setProdId(wishlist.getCompositeId().getProdId());
		return wishDTO;
	}
	

	@Override
	public void createBuyerList(WishlistDTO listDTO) {
		Wishlist wishlist = listDTO.createEntity();
		wishlistRepository.save(wishlist);
	}

	@Override
	public String wishToCart(CartDTO cartDTO) throws Exception {
		// TODO Auto-generated method stub
		CompositeTable c=new CompositeTable();
		c.setBuyerId(cartDTO.getBuyerId());
		c.setProdId(cartDTO.getProdId());
		Optional<Wishlist> dataProduct = wishlistRepository.findById(c);
		try {
			if(dataProduct.isEmpty())
				throw new Exception("No such product exists in wishlist");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Cart cart=new Cart();
		cart.setCompositeId(c);
		cart.setQuantity(cartDTO.getQuantity());
		cartRepository.save(cart);
		wishlistRepository.deleteById(c);
//		CartDTO cDTO=new CartDTO();
//		cDTO.setBuyerId(cart.getCompositeId().getBuyerId());
//		cDTO.setProdId(cart.getCompositeId().getProdId());
//		cDTO.setQuantity(cart.getQuantity());
		return "successfully added idem to cart from wishlist";
	}

	@Override
	public CartDTO cartData(String buyerId, String prodId,int quantity) {
		// TODO Auto-generated method stub
		Cart c=new Cart();
		CompositeTable ct=new CompositeTable();
		ct.setBuyerId(buyerId);
		ct.setProdId(prodId);
		c.setCompositeId(ct);
		c.setQuantity(quantity);
		cartRepository.save(c);
		CartDTO cDTO=new CartDTO();
		cDTO.setBuyerId(c.getCompositeId().getBuyerId());
		cDTO.setProdId(c.getCompositeId().getProdId());
		cDTO.setQuantity(c.getQuantity());
		return cDTO;
	}



}
