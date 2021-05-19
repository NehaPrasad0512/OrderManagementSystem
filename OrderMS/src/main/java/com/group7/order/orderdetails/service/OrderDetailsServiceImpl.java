package com.group7.order.orderdetails.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group7.order.orderdetails.dto.CartDTO;
import com.group7.order.orderdetails.dto.OrderDetailsDTO;
import com.group7.order.orderdetails.dto.ProductDTO;
import com.group7.order.orderdetails.entity.Order;
import com.group7.order.orderdetails.repository.OrderDetailsRepository;


@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService{
	static int val=1000;
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
	public List<OrderDetailsDTO> viewAllOrders() throws Exception{
		
		Iterable<Order> orders = orderRepository.findAll();
		
		if(orders==null) {
			throw new Exception("orders are empty");
		}
		
		List<OrderDetailsDTO> dto = new ArrayList<>();
		
		for(Order o : orders) {
			OrderDetailsDTO val = new OrderDetailsDTO();
			val.setBuyerId(o.getBuyerId());
			val.setAddress(o.getAddress());
			val.setAmount(o.getAmount());
			val.setDate(o.getDate());
			val.setStatus(o.getStatus());
			val.setOrderId(o.getOrderId());
			
			dto.add(val);			
		}
		return dto;
		
	}
	public List<String> placeOrder(List<CartDTO> cartItem) throws Exception{
		String str;
		List<String> list=new ArrayList<>();
		List<CartDTO> buyerDetail=new ArrayList<>();
		for( CartDTO c:cartItem) {
			CartDTO value=new CartDTO();
			value.setBuyerId(c.getBuyerId());
			value.setProdId(c.getProdId());
			value.setQuantity(c.getQuantity());
			str="O"+(val++);
			String dataOrder = this.OrderDone(value.getBuyerId(),value.getProdId(),str);	
			list.add(dataOrder);
		
			buyerDetail.add(c);
		}
		return list;
	}
	
	@Override
	public String OrderDone(String buyerId,String prodId,String value) {
		Order order=new Order();
		//LocalDate dateToday=LocalDate.now();
		order.setOrderId(value);
		order.setAmount(1000);
		Date date=new Date();
		order.setBuyerId(buyerId);
		order.setStatus("Order Placed");
		order.setAddress("Kalyan");
		order.setDate(date);
		orderRepository.save(order);
		return order.getOrderId();
	}

	@Override
	public ProductDTO getProduct() {
		// TODO Auto-generated method stub
			
		return null;
	}
		
}
