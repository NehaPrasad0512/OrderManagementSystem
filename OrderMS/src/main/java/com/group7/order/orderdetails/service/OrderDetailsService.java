package com.group7.order.orderdetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group7.order.orderdetails.dto.OrderDetailsDTO;

@Service
public interface OrderDetailsService {
	
	public String addProductToCart(OrderDetailsDTO orderDetailsDTO) throws Exception;
	
	public String deleteProductFromCart(String prodId) throws Exception;
	
	public OrderDetailsDTO viewOrders(String orderId) throws Exception;
	
	public OrderDetailsDTO placeOrder(String prodId) throws Exception;
	
	
	
	

}
