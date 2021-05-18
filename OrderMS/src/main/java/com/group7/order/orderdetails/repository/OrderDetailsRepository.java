package com.group7.order.orderdetails.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group7.order.orderdetails.entity.Order;


@Repository(value="orderRepository")
public interface OrderDetailsRepository extends CrudRepository<Order,String>{
	Order findByOrderId(String orderId);

}
