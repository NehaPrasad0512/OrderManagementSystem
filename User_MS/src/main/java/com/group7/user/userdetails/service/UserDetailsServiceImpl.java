package com.group7.user.userdetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group7.user.userdetails.dto.BuyerDTO;
import com.group7.user.userdetails.dto.CartDTO;
import com.group7.user.userdetails.dto.LoginDTO;
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
import com.group7.user.userdetails.validator.Validator;

@Service("userDetailsServiceImpl")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

	
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
		try {
			if(Validator.validateBuyer(buyerdto)) {
			Buyer buyer=new Buyer();
			buyer.setBuyerId(buyerdto.getBuyerId());
			buyer.setEmail(buyerdto.getEmail());
			buyer.setName(buyerdto.getName());
			buyer.setPassword(buyerdto.getPassword());
			buyer.setIsActive(buyerdto.getIsActive());
			buyer.setPhoneNumber(buyerdto.getPhoneNumber());
			buyer.setIsPiviledged( buyerdto.getIsPiviledged());
			buyer.setRewardPoints(buyerdto.getRewardPoints());
			userDetailsRepository.save(buyer);
			return buyer.getBuyerId();}
			else return null;
		} catch (Exception e) {
			return e.getMessage();
		}
		}

	@Override
	public String registerSellerUser(SellerDTO sellerdto) {
		try {
			if(Validator.validateSeller(sellerdto))
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
		} catch (Exception e) {
				return e.getMessage();
		}
	}

	@Override
	public String loginBuyerUser(String email,String password) throws Exception {
		Optional<Buyer> emailId = userDetailsRepository.findByEmail(email);
		
		if(emailId.isEmpty()) {
			throw new Exception("No buyer with such email exists"); 
		}
		if(emailId.get().getPassword().equals(password)) {
		BuyerDTO buyerdto=new BuyerDTO();
		buyerdto.setEmail(email);
		buyerdto.setPassword(password);
		buyerdto.setIsActive("yes");
		return "SELLER SUCCESSFUL LOGIN";}
		else
			return "SELLER UNSUCCESSFULL LOGIN";
	}
	
	@Override
	public String loginBuyer(LoginDTO loginDTO) throws Exception {
		Optional<Buyer> emailId = userDetailsRepository.findByEmail(loginDTO.getEmail());
		
		if(emailId.isEmpty()) {
			throw new Exception("No buyer with such email exists"); 
		}
		if(emailId.get().getPassword().equals(loginDTO.getPassword())) {
		BuyerDTO buyerdto=new BuyerDTO();
		buyerdto.setEmail(emailId.get().getEmail());
		buyerdto.setPassword(emailId.get().getPassword());
		buyerdto.setIsActive("yes");
		return "BUYER_SUCCESS_LOGIN";}
		else
			return "LOGIN_UNSUCCESSFUL";

	}

	
	@Override
	public String loginSellerUser(String email, String password) throws Exception {
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
	public String loginSeller(LoginDTO login) throws Exception {
		Optional<Seller> emailSeller = sellerRepository.findByEmail(login.getEmail());
		if(emailSeller.isEmpty())
			throw new Exception("No seller with such email exists"); 
		if(emailSeller.get().getPassword().equals(login.getPassword())) {
		SellerDTO sellerdto=new SellerDTO();
		sellerdto.setEmail(emailSeller.get().getEmail());
		sellerdto.setPassword(emailSeller.get().getPassword());
		sellerdto.setIsActive("yes");
		return "Successfully logged in";}else
			return "login unsuccessful";

	}
	@Override
	public String deleteBuyer(String buyerId) throws Exception {
		Optional<Buyer> buyerDelete = userDetailsRepository.findById(buyerId);
		if(buyerDelete.isEmpty())
			throw new Exception("No buyer with such buyerId exists"); 
		userDetailsRepository.deleteById(buyerId);
		
		return "Deleted successfully";
	}

	@Override
	public String deleteSeller(String sellerId) throws Exception {
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
		
		CompositeTable c=new CompositeTable();
		c.setBuyerId(cartDTO.getBuyerId());
		c.setProdId(cartDTO.getProdId());
		Optional<Wishlist> dataProduct = wishlistRepository.findById(c);
		try {
			if(dataProduct.isEmpty())
				throw new Exception("WISHLIST.NO_SUCH_PRODUCT");
		} catch (Exception e) {
			throw new Exception("WISHLIST.NO_SUCH_PRODUCT");
		}
		Cart cart=new Cart();
		cart.setCompositeId(c);
		cart.setQuantity(cartDTO.getQuantity());
		cartRepository.save(cart);
		wishlistRepository.deleteById(c);
		return "successfully added idem to cart from wishlist";
	}

	@Override
	public CartDTO cartData(String buyerId, String prodId,int quantity) {
		Cart cart=new Cart();
		CompositeTable compositeTable=new CompositeTable();
		compositeTable.setBuyerId(buyerId);
		compositeTable.setProdId(prodId);
		cart.setCompositeId(compositeTable);
		cart.setQuantity(quantity);
		cartRepository.save(cart);
		CartDTO cartDTO=new CartDTO();
		cartDTO.setBuyerId(cart.getCompositeId().getBuyerId());
		cartDTO.setProdId(cart.getCompositeId().getProdId());
		cartDTO.setQuantity(cart.getQuantity());
		return cartDTO;
	}

	@Override
	public List<CartDTO> viewAllCart() throws Exception {
		List<CartDTO> listItem=new ArrayList<>();
		Iterable<Cart> valueProduct = cartRepository.findAll();
		if(valueProduct==null)
			throw new Exception("No items in cart");
		for(Cart cart:valueProduct) {
			CartDTO cartDTO=new CartDTO();
			cartDTO.setBuyerId(cart.getCompositeId().getBuyerId());
			cartDTO.setProdId(cart.getCompositeId().getProdId());
			cartDTO.setQuantity(cart.getQuantity());
			listItem.add(cartDTO);
		}
		return listItem;
	}

	public String deleteFromCart(String prodId,String buyerId) {
		CompositeTable compositeTable=new CompositeTable();
		compositeTable.setBuyerId(buyerId);
		compositeTable.setProdId(prodId);
		cartRepository.deleteById(compositeTable);
		return compositeTable.getProdId();
	}

}
