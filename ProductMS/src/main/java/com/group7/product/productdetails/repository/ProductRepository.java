package com.group7.product.productdetails.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.group7.product.productdetails.entity.Product;

@Repository(value="productRepository")
public interface ProductRepository extends CrudRepository<Product,String>{

	public Optional<Product> findByProductName(String productName);
	
	public List<Product> findByCategory(String category);

	public Optional<Product> findByProdId(String prodId);
	
}
