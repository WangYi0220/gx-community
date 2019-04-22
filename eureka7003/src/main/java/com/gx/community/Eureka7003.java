package com.gx.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/10 9:58
 * @description：
 * @modified By：
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka7003 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7003.class, args);
    }
}
