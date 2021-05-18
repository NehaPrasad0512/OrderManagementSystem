package com.group7.product.productdetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group7.product.productdetails.dto.ProductDTO;
import com.group7.product.productdetails.entity.Product;
import com.group7.product.productdetails.repository.ProductRepository;
import com.group7.product.productdetails.validator.Validator;

@Service
@Transactional
public class ProductDetailsServiceImpl implements ProductDetailsService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	@Transactional
	public String addProduct(ProductDTO productdto) throws Exception {
		// TODO Auto-generated method stub
		//Optional<Product> details = productRepository.findByProductName(productdto.getProductName());
		try {
			if(Validator.ValidateProduct(productdto)) {
				Product product=new Product();
				product.setProdID(productdto.getProdID());
				product.setProductName(productdto.getProductName());
				product.setDescription(productdto.getDescription());
				product.setCategory(productdto.getCategory());
				product.setImage(productdto.getImage());
				product.setPrice(productdto.getPrice());
				product.setSellerId(productdto.getSellerId());
				product.setSubcategory(productdto.getSubcategory());
				product.setProductRating(productdto.getProductRating());
				product.setStock(productdto.getStock());
				System.out.println(productRepository.save(product));
				
				return product.getProdID();}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();	
		}
		return null;
	}

	@Override
	@Modifying
	@Transactional
	public String deleteProduct(String prodId) throws Exception{
		// TODO Auto-generated method stub
		Optional<Product> productDetail = productRepository.findById(prodId);
		if(productDetail.isEmpty())
			throw new Exception("ProductId not found to delete");
		productRepository.deleteById(prodId);
		String message="Successfully deleted from product detail";
		return message;
		
	}


	@Override
	public List<ProductDTO> CartCategory(String category) throws Exception {
		// TODO Auto-generated method stub
		List<Product> dataCategory = productRepository.findByCategory(category);
		List<ProductDTO> pdto=new ArrayList<>();
		if(dataCategory.isEmpty())
			throw new Exception("Product does not exist for such category");
		for(Product p:dataCategory) {
			ProductDTO val=new ProductDTO();
			val.setProdID(p.getProdID());
			val.setProductName(p.getProductName());
			val.setCategory(p.getCategory());
			val.setDescription(p.getDescription());
			val.setImage(p.getImage());
			val.setProductRating(p.getProductRating());
			val.setPrice(p.getPrice());
			val.setSellerId(p.getSellerId());
			val.setStock(p.getStock());
			val.setSubcategory(p.getSubcategory());
			pdto.add(val);
			System.out.println(pdto);
		}
		return pdto;
	}

	@Override
	public ProductDTO CartProductName(String productName) throws Exception {
		// TODO Auto-generated method stub
		Optional<Product> product = productRepository.findByProductName(productName);
		if(product.isEmpty())
			throw new Exception("Product does not exist");
		ProductDTO p=new ProductDTO();
		p.setProdID(product.get().getProdID());
		p.setProductName(product.get().getProductName());
		p.setCategory(product.get().getCategory());
		p.setDescription(product.get().getDescription());
		p.setImage(product.get().getImage());
		p.setProductRating(product.get().getProductRating());
		p.setPrice(product.get().getPrice());
		p.setSellerId(product.get().getSellerId());
		p.setStock(product.get().getStock());
		p.setSubcategory(product.get().getSubcategory());
		return p;
		
	}

	@Override
	public ProductDTO getSpecificProduct(String productName) {
		// TODO Auto-generated method stub
		
		return ProductDTO.valueOf(productRepository.findByProductName(productName));
	}
	

	
}
