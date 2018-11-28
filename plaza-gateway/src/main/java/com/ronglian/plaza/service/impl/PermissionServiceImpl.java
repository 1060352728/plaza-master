package com.ronglian.plaza.service.impl;

import com.ronglian.plaza.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**  
 * @methord:   根据token判断是否有当前路径访问权限
 * @author： likui
 * @great： 2018/11/21 19:18
 */ 
@Service("permissionService")
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    /**
     * 可以做URLs匹配，规则如下
     *
     * ？匹配一个字符
     * *匹配0个或多个字符
     * **匹配0个或多个目录
     * 用例如下
     * <p>https://www.cnblogs.com/zhangxiaoguang/p/5855113.html</p>
     */

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        String requestUrl = request.getRequestURI();
        log.info("requestUrl:{}",requestUrl);
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        boolean hasPermission = false;

        if (principal != null)
        {
            if (CollectionUtils.isEmpty(grantedAuthorityList))
            {
                return hasPermission;
            }
            for (SimpleGrantedAuthority authority:grantedAuthorityList)
            {
                if (antPathMatcher.match(authority.getAuthority(),requestUrl)){
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}
