package com.ronglian.plaza;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
SpringCloudApplication
包含了
  @SpringBootApplication，
  @EnableCircuitBreaker服务降级，
  @EnableDiscoveryClient）
*/

@SpringCloudApplication
@EnableFeignClients
@MapperScan("com.ronglian.plaza.uac.mapper")
public class PlazaProviderUacApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlazaProviderUacApplication.class, args);
	}
}
