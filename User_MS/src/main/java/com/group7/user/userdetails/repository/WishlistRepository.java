package com.group7.user.userdetails.repository;

import org.springframework.data.repository.CrudRepository;

import com.group7.user.userdetails.entity.CompositeTable;
import com.group7.user.userdetails.entity.Wishlist;

public interface WishlistRepository extends CrudRepository<Wishlist,CompositeTable>{

}
