package com.group7.user.userdetails.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group7.user.userdetails.entity.Cart;
import com.group7.user.userdetails.entity.CompositeTable;

@Repository
public interface CartRepository  extends CrudRepository<Cart,CompositeTable> {

}
