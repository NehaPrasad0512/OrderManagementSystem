package com.group7.order.orderdetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group7.order.orderdetails.dto.CartDTO;
import com.group7.order.orderdetails.dto.OrderDetailsDTO;
import com.group7.order.orderdetails.dto.ProductDTO;
import com.group7.order.orderdetails.dto.SellerStatus;

@Service
public interface OrderDetailsService {
	
	public String addProductToCart(OrderDetailsDTO orderDetailsDTO) throws Exception;
	
	public String deleteProductFromCart(String prodId) throws Exception;
	
	public OrderDetailsDTO viewOrders(String orderId) throws Exception;
	
	public List<String> placeOrder(List<CartDTO> cartItem,SellerStatus info) throws Exception;
	
	public List<OrderDetailsDTO> viewAllOrders() throws Exception;
	
	String OrderDone(String buyerId, String prodId, String value, String address, float price);
	
	
	

}
