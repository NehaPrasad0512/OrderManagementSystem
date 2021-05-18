package com.group7.order.orderdetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group7.order.orderdetails.dto.OrderDetailsDTO;

@Service
public interface OrderDetailsService {
	
	public String addProductFromCart(OrderDetailsDTO orderDetailsDTO) throws Exception;
	
	public String deleteProductFromCart(String prodId) throws Exception;
	
	public List<OrderDetailsDTO> viewOrders(String orderId) throws Exception;
	
	

}
