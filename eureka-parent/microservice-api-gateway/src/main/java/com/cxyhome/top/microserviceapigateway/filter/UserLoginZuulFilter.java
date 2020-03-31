package com.cxyhome.top.microserviceapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserLoginZuulFilter extends ZuulFilter {

    /**
     * 是否通过这个过滤器，默认为true，改成false则不启用
     * @return
     */
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
     * 过滤器类型选择：
     * pre 为路由前
     * route 为路由过程中
     * post 为路由过程后
     * error 为出现错误的时候
     * 同时也支持static ，返回静态的响应，详情见StaticResponseFilter的实现
     * 以上类型在会创建或添加或运行在FilterProcessor.runFilters(type)
     */
     @Override
    public String filterType() {
        return "pre"; // 设置过滤器类型为：pre
    }

    /**
     *  用来过滤器排序执行的 通过返回的int值来定义过滤器的执行顺序，数字越小优先级越高。
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;// 设置执行顺序为0
    }


}