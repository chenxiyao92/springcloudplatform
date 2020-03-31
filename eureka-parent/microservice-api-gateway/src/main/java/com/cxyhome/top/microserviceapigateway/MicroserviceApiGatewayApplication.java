package com.cxyhome.top.microserviceapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class MicroserviceApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceApiGatewayApplication.class, args);
    }

    /**
     * PatternServiceRouteMapper对象可以让开发者通过正则表达式来自定义服务与路由映射的生成关系。
     * 其中构造函数的第一个参数用来匹配服务名称是否符合该自定义规则的正则表达式（serviceId），
     * 而第二个参数则是定义服务名中定义的内容转换出的路径表达式(path)，
     * 只要有符合第一个参数定义的serviceId，那么就会优先使用该实现构建出path，
     * 如果没有找到则使用默认路由映射需——采用完整服务名做为前缀的路径表达式。
     *
     * 如果有一个可以同时满足多个path的匹配的情况，此时匹配结果取决于路由规则的定义顺序，
     * 这里需要注意的是：properties无法保证路由规则的顺序，推荐使用yml格式配置文件
     * @return
     */
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper(){
        // 调用构造函数 PatternServiceRouteMapper (String servicePattern  ,String routePattern)
        //servicePattern 指定微服务的正则
        //routePattern 指定路由正则
        return new PatternServiceRouteMapper("","");

    }

}
