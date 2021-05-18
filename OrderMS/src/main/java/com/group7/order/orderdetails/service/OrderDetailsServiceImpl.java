package com.group7.order.orderdetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group7.order.orderdetails.dto.OrderDetailsDTO;
import com.group7.order.orderdetails.entity.Order;
import com.group7.order.orderdetails.repository.OrderDetailsRepository;


@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService{
	
	@Autowired
	OrderDetailsRepository orderRepository;

	@Override
	public String addProductToCart(OrderDetailsDTO orderDetailsDTO) throws Exception {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setBuyerId(orderDetailsDTO.getBuyerId());
		order.setAddress(orderDetailsDTO.getAddress());
		order.setAmount(orderDetailsDTO.getAmount());
		order.setDate(orderDetailsDTO.getDate());
		order.setStatus(orderDetailsDTO.getStatus());
		
		order.setOrderId(orderDetailsDTO.getOrderId());
		orderRepository.save(order);
		
		
		return order.getOrderId();
	}

	@Override
	public String deleteProductFromCart(String prodId) throws Exception {
		// TODO Auto-generated method stub
		
		Optional<Order> orderDetail = orderRepository.findById(prodId);
		if(orderDetail.isEmpty())
			throw new Exception("ProductId not found to delete");
		orderRepository.deleteById(prodId);
		String message="Successfully deleted from product detail";
		return message;
	}

	@Override
	public OrderDetailsDTO viewOrders(String orderId) throws Exception {
		// TODO Auto-generated method stub
		Order order = orderRepository.findByOrderId(orderId);
		
		OrderDetailsDTO dto = new OrderDetailsDTO();
		
		if(order==null) {
			throw new Exception("orderId does not exists");
		}
		
		dto.setBuyerId(order.getBuyerId());
		dto.setAddress(order.getAddress());
		dto.setAmount(order.getAmount());
		dto.setDate(order.getDate());
		dto.setStatus(order.getStatus());
		dto.setOrderId(order.getOrderId());
		
		return dto;
	}

	@Override
	public String placeOrder(String prodId) throws Exception {
		// TODO Auto-generated method stub
		
		
		return null;
	}

}
