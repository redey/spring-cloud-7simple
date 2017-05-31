package com.dady.cloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
@RefreshScope
@EnableDiscoveryClient //使用eureka注册服务器
@SpringBootApplication

@Configuration
@EnableAutoConfiguration
public class SimpleService {
    public static void main(String[] args) {
        SpringApplication.run(SimpleService.class, args);
    }
    
    
}