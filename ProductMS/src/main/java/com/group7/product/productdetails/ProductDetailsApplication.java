package com.group7.product.productdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ProductDetailsApplication {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	SpringApplication.run(ProductDetailsApplication.class, args);

	}

}
