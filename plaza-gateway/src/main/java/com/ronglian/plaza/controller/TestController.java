package com.ronglian.plaza.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author likui
 * @Classname: TestController
 * @Description: 测试动态刷新配置
 * @create 2018-11-01 9:28
 **/
@RestController
@RefreshScope
public class TestController {

    @Value("${name}")
    private String name;

    @RequestMapping("/geteway")
    public String getway(){
        return name;
    }
}
