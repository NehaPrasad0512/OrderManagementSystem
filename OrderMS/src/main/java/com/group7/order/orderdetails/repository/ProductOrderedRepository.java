package com.group7.order.orderdetails.repository;

import org.springframework.data.repository.CrudRepository;

import com.group7.order.orderdetails.entity.CompositeTable;
import com.group7.order.orderdetails.entity.ProductOrdered;


public interface ProductOrderedRepository extends CrudRepository<ProductOrdered,CompositeTable>{

}
