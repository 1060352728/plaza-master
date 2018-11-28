package com.ronglian.plaza;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ronglian.plaza.psc.mapper")
@EnableSwagger2
public class PlazaProviderPscApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlazaProviderPscApplication.class, args);
	}
}
