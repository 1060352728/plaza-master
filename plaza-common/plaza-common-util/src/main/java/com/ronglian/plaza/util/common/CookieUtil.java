package com.ronglian.plaza.util.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookik工具类
 */
public class CookieUtil {

    /**
     * 设置cookie
     * @param response
     * @param name
     * @param valus
     * @param maxAge
     */
    public static void set(HttpServletResponse response,String name,String valus,int maxAge){
        Cookie cookie = new Cookie(name,valus);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 获取cookie
     * @param request
     * @param name
     * @return
     */
    public static Cookie get(HttpServletRequest request,String name){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(name.equals(cookie.getName())){
                    return cookie;
                }
            }
        }
        return null;
    }
}
