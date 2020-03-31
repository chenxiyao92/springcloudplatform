package com.cxyhome.top.orderservicecompose;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//@MapperScan("com.cxyhome.top.itemservicecompose.mapper")
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients(basePackages = "com.cxyhome.top.orderservicecompose.feign")
public class OrderServiceComposeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceComposeApplication.class, args);
    }

    /**
     * 向Spring容器中定义RestTemplate对象
     * 使用okhttpclient代替 RestTemple
     * @return
     */
    @Bean(name = "myRestTemplate")
    //开启软均衡负载
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
