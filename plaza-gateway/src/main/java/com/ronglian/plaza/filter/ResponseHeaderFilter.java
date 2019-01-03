package com.ronglian.plaza.filter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.ronglian.plaza.util.common.JsonUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.UUID;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_RESPONSE_FILTER_ORDER;
import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

/**
 * 过滤器响应头中添加信息
 */
@Component
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
            InputStream stream = context.getResponseDataStream();
            String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
            Map<String, String> map = (Map<String, String>) JsonUtil.fromJson(body,new TypeReference<Map<String, String>>() {});
            Integer code = context.getResponseStatusCode();
            String url = context.getRequest().getRequestURI();
            if(url.indexOf("/oquth/token") < 0 && code != 200){
                map.put("code",code.toString());
                context.setResponseStatusCode(200);
            }
            context.setResponseBody(map.toString());
        }
        catch (Exception e) {

        }
        return null;
    }
}
