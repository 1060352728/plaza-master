package com.ronglian.plaza.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * @author likui
 * @Classname: RateLimiter
 * @Description: 限流过滤器
 * @create 2018-11-01 19:07
 **/
@Component
public class MyRateLimiter extends ZuulFilter {

    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 最高的优先级
     * @return
     */
    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //没有获取到令牌
        /*if(!RATE_LIMITER.tryAcquire()){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.GATEWAY_TIMEOUT.value());//超时，请稍后访问504
        }*/
        return null;
    }
}
