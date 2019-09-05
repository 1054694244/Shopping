package com.shenzc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author shenzc
 * @create 2019-09-05-8:46
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.shenzc")
public class ShenzcUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShenzcUserApplication.class,args);
    }

}
