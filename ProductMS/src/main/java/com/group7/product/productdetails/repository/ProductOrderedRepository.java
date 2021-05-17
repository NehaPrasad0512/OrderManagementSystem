package com.group7.product.productdetails.repository;

import org.springframework.data.repository.CrudRepository;

import com.group7.product.productdetails.entity.CompositeTable;
import com.group7.product.productdetails.entity.SubscribedProduct;

public interface ProductOrderedRepository extends CrudRepository<SubscribedProduct,CompositeTable>{

}
