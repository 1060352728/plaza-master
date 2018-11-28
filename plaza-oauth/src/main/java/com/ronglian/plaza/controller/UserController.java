package com.ronglian.plaza.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author likui
 * @Classname: UserController
 * @Description: 測試控制器
 * @create 2018-11-17 19:30
 * <p>必须要有，做验证</p>
 **/
@RestController
public class UserController {
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
