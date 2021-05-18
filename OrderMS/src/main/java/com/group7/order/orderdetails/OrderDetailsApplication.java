package com.group7.order.orderdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//commiting
@SpringBootApplication
@EnableDiscoveryClient
public class OrderDetailsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderDetailsApplication.class, args);

	}

}
