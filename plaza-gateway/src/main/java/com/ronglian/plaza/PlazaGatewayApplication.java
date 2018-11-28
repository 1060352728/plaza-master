package com.ronglian.plaza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringCloudApplication
@EnableZuulProxy
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class PlazaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlazaGatewayApplication.class, args);
	}

	@ConfigurationProperties("zuul")
	@RefreshScope   //动态刷新配置
	public ZuulProperties zuulProperties() {
		return new ZuulProperties();
	}
}
