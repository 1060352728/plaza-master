package com.ronglian.plaza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PlazaEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlazaEurekaApplication.class, args);
	}
}
