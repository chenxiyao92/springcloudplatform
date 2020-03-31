package com.cxyhome.top.microserviceapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserLoginZuulFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        return true; // 该过滤器需要执行
    }

    @Override
    public Object run() { //编写业务逻辑
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            requestContext.setSendZuulResponse(false); // 过滤该请求，不对其进行路由
            requestContext.setResponseStatusCode(401); // 设置响应状态码
            requestContext.setResponseBody(" token is empty!!"); // 设置响应状态码
            return null;
        }
        return null;
    }

    /**
     * a)pre：请求在被路由之前执行
     * b)routing：在路由请求时调用
     * c)post：在routing和errror过滤器之后调用
     * d)error：处理请求时发生错误调用
     * @return
     */
     @Override
    public String filterType() {
        return "pre"; // 设置过滤器类型为：pre
    }

    /**
     * 通过返回的int值来定义过滤器的执行顺序，数字越小优先级越高。
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;// 设置执行顺序为0
    }
}