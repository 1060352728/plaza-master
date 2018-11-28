package com.ronglian.plaza;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
@EnableHystrixDashboard
@MapperScan("com.ronglian.plaza.omc.mapper")
public class PlazaProviderOmcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlazaProviderOmcApplication.class, args);
	}
}
