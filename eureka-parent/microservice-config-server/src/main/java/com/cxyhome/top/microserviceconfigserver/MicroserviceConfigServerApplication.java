package com.cxyhome.top.microserviceconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 开启配置服务
 */
@EnableConfigServer
@SpringBootApplication
public class MicroserviceConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConfigServerApplication.class, args);
    }

}
