package com.ronglian.plaza.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.ronglian.plaza.util.common.CookieUtil;
import com.ronglian.plaza.util.constant.CookieConstant;
import com.ronglian.plaza.util.constant.RedisConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 权限过滤器
 */
@Component
@Slf4j
public class AuthFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;//int值来定义过滤器的执行顺序，数值越小优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        return null;
    }

   /* @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        //1:  /order/creat   只能买家访问(cookie中有openid)
        if("/api-omc/order/creat".equals(request.getRequestURI())){
            Cookie cookie = CookieUtil.get(request, CookieConstant.OPENID);
            if(cookie == null || StringUtils.isBlank(cookie.getValue())){
                requestContext.setSendZuulResponse(false);
                //401 权限不足
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }
        //2:  /order/finish  只能卖家访问（cookie中有token，并且缓存中有值）
        if("/api-omc/order/finish".equals(request.getRequestURI())){
            Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
            if(cookie == null || StringUtils.isBlank(cookie.getValue())){
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }else{
                String redisValues = stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue()));
                if(StringUtils.isBlank(redisValues)){
                    requestContext.setSendZuulResponse(false);
                    requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                }
            }
        }
        //3： /product/list  都可以访问
        return null;
    }*/
}
