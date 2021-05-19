package com.group7.order.orderdetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group7.order.orderdetails.dto.CartDTO;
import com.group7.order.orderdetails.dto.OrderDetailsDTO;
import com.group7.order.orderdetails.dto.ProductDTO;

@Service
public interface OrderDetailsService {
	
	public String addProductToCart(OrderDetailsDTO orderDetailsDTO) throws Exception;
	
	public String deleteProductFromCart(String prodId) throws Exception;
	
	public OrderDetailsDTO viewOrders(String orderId) throws Exception;
	
	public List<String> placeOrder(List<CartDTO> cartItem) throws Exception;
	
	public String OrderDone(String buyerId,String prodId,String value);
	public List<OrderDetailsDTO> viewAllOrders() throws Exception;
	public ProductDTO getProduct();
	
	
	

}
