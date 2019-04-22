package com.gx.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/10 16:43
 * @description：
 * @modified By：
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.gx.community"})
public class CommunityConsumer {
    public static void main(String[] args) {
        SpringApplication.run(CommunityConsumer.class, args);
    }
}
