package com.shenzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 婵大pig
 * @create 2019-08-21 14:11
 */
@SpringBootApplication
@EnableEurekaServer     //声明这个应用是一个EurekaServer
public class ShenzcRegistry {

    public static void main(String[] args){
        SpringApplication.run(ShenzcRegistry.class,args);
    }

}
