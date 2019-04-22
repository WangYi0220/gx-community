package com.gx.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/10 9:10
 * @description：
 * @modified By：
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka7001 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7001.class, args);
    }
}
