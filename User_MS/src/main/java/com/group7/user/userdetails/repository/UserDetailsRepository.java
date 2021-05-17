package com.group7.user.userdetails.repository;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.group7.user.userdetails.entity.Buyer;

@Repository(value="userDetailsRepository")
public interface UserDetailsRepository extends CrudRepository<Buyer,String> {

	public Optional<Buyer> findByEmail(String email);
	
	public Optional<Buyer> findById(String buyerId);
	
	@Query("DELETE FROM Buyer b WHERE b.buyerId = :buyerId")
	@Modifying
	@Transactional
	public void deleteById(@Param("buyerId") String buyerId);
}
