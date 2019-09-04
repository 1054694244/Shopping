package com.shenzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shenzc
 * @create 2019-09-04-17:04
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ShenzcAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShenzcAuthApplication.class,args);
    }

}
