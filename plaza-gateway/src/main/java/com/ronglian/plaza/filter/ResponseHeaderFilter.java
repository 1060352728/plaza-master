package com.ronglian.plaza.filter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.ronglian.plaza.util.common.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
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
            if(url.indexOf("/oauth/token") > 0 && code == 401){
                InputStream stream = context.getResponseDataStream();
                String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
                Map<String, String> map = (Map<String, String>) JsonUtil.fromJson(body,new TypeReference<Map<String, String>>() {});
                map.put("code",code.toString());
                context.setResponseStatusCode(200);
                context.setResponseBody(map.toString());
            }
        }
        catch (Exception e) {
            log.error("登录出错",e);
        }
        return null;
    }
}
