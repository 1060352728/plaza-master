package com.ronglian.plaza.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import static com.netflix.zuul.context.RequestContext.getCurrentContext;

/**
 * 过滤器响应头中添加信息
 */
@Component
@Slf4j
public class ResponseHeaderFilter extends ZuulFilter{

    public String filterType() {
        return "post";
    }

    public int filterOrder() {
        return 999;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        try {
            RequestContext context = getCurrentContext();
            String url = context.getRequest().getRequestURI();
            Integer code = context.getResponseStatusCode();
            if(url.indexOf("/oauth/token") > 0 && code != 200){
                context.setResponseStatusCode(200);
                context.setResponseBody(code.toString());
            }
        }
        catch (Exception e) {
            log.error("登录出错");
        }
        return null;
    }
}
