package com.cxyhome.top.demoservicecompose;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.cxyhome.top.demoservicecompose.mapper")
@EnableEurekaClient
@SpringBootApplication
public class DemoServiceComposeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoServiceComposeApplication.class, args);
    }

}
