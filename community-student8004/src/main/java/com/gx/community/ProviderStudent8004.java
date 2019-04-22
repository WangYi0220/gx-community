package com.gx.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/11 8:42
 * @description：
 * @modified By：
 */
@SpringBootApplication
@MapperScan("com.gx.community.mapper")
@EnableSwagger2
@EnableCaching
@EnableTransactionManagement
@EnableEurekaClient
public class ProviderStudent8004 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderStudent8004.class, args);
    }
}
