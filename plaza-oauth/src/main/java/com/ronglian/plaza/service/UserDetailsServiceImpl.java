package com.ronglian.plaza.service;

import com.ronglian.plaza.common.entity.uac.MenuInfo;
import com.ronglian.plaza.common.entity.uac.RoleInfo;
import com.ronglian.plaza.common.entity.uac.UserInfo;
import com.ronglian.plaza.uac.client.UserFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author likui
 * @Classname: UserDetailsServiceImpl
 * @Description: 用户查询
 * @create 2018-11-16 17:18
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserFeignApi userFeignApi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userFeignApi.findByUsername(username);
        if (null == userInfo)
        {
            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        boolean enabled = true; // 可用性 :true:可用 false:不可用
        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定
        RoleInfo roleInfo = userFeignApi.findRoleByRoleId(userInfo.getRole().toString());
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+roleInfo.getRoleValue());
        grantedAuthorities.add(grantedAuthority);
        //获取权限
        List<MenuInfo> menuInfoList = userFeignApi.findMenus(roleInfo.getId().toString());
        for (MenuInfo menu:menuInfoList)
        {
            GrantedAuthority authority = new SimpleGrantedAuthority(menu.getMenuCode());
            grantedAuthorities.add(authority);
        }
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;
    }
}
