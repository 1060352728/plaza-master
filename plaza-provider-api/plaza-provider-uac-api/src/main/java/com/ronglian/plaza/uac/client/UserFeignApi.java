package com.ronglian.plaza.uac.client;

import com.ronglian.plaza.common.entity.uac.MenuInfo;
import com.ronglian.plaza.common.entity.uac.RoleInfo;
import com.ronglian.plaza.common.entity.uac.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "plaza-provider-uac")
public interface UserFeignApi {

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @PostMapping("/user/findbyusername/{username}")
    public UserInfo findByUsername(@PathVariable("username") String username);

    @PostMapping("/user/findrole/{roleId}")
    public RoleInfo findRoleByRoleId(@PathVariable("roleId") String roleId);

    @PostMapping("/user/findmenus/{roleId}")
    public List<MenuInfo> findMenus(@PathVariable("roleId") String roleId);


}
