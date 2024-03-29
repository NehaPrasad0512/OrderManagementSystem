package com.group7.reskill.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//Eureka file
@SpringBootApplication
@EnableEurekaServer
public class InfytelDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfytelDiscoveryServerApplication.class, args);
	}
}
