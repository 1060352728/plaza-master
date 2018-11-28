package com.ronglian.plaza.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by likui on 2018/11/15.
 * Description:
 * Date: 2018-05-14
 * Time: 16:01
 */
public interface PermissionService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
