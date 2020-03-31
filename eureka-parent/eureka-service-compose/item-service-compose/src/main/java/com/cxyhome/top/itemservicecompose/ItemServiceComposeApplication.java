package com.cxyhome.top.itemservicecompose;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.cxyhome.top.itemservicecompose.mapper")
@EnableEurekaClient
@SpringBootApplication
public class ItemServiceComposeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemServiceComposeApplication.class, args);
    }

}
