package com.gx.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/10 19:57
 * @description：
 * @modified By：
 */
@SpringBootApplication
@EnableZuulProxy
public class CommunityZuul80 {
    public static void main(String[] args) {
        SpringApplication.run(CommunityZuul80.class, args);
    }
}
