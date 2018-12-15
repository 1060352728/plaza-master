package com.ronglian.plaza.uac.controller;

import com.ronglian.plaza.common.entity.uac.MenuInfo;
import com.ronglian.plaza.common.entity.uac.RoleInfo;
import com.ronglian.plaza.common.entity.uac.UserInfo;
import com.ronglian.plaza.uac.service.MenuInfoService;
import com.ronglian.plaza.uac.service.RoleService;
import com.ronglian.plaza.uac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author likui
 * @Classname: UserController
 * @Description: 用户控制器
 * @create 2018-11-16 17:32
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuInfoService menuInfoService;

    @RequestMapping("/findbyusername/{username}")
    public UserInfo findByUserName(@PathVariable("username") String username){
        UserInfo userInfo = userService.findByUsername(username);
        return userInfo;
    }

    @RequestMapping("/findrole/{roleId}")
    public RoleInfo findRoleByRoleId(@PathVariable("roleId") String roleId){
        RoleInfo roleInfo = roleService.findById(Integer.parseInt(roleId));
        return roleInfo;
    }

    @RequestMapping("/findmenus/{roleId}")
    public List<MenuInfo> findMenus(@PathVariable("roleId") String roleId){
        List<MenuInfo> menuInfoList = menuInfoService.findMenus(Integer.parseInt(roleId));
        return menuInfoList;
    }

    @PostMapping("/findbyusername")
    public UserInfo findByUser(@RequestParam("username") String username){
        UserInfo userInfo = userService.findByUsername(username);
        return userInfo;
    }

}
