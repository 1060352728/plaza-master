package com.ronglian.plaza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * @author likui
 * @Classname: CorsConfig
 * @Description: 跨域配置
 * @create 2018-11-02 13:26
 **/
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);//允许cookie跨域
        config.setAllowedOrigins(Arrays.asList("*"));//原始域，自己定义的域名
        config.setAllowedHeaders(Arrays.asList("*"));//允许的头
        config.setAllowedMethods(Arrays.asList("*"));//允许的get和post请求
        config.setMaxAge(200l);//相同的请求200秒之内不会再去查

        source.registerCorsConfiguration("/**",config);
        return new CorsFilter(source);
    }
}
