package com.shenzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shenzc
 * @create 2019-09-04-15:07
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ShenzcSearchService {

    public static void main(String[] args) {
        SpringApplication.run(ShenzcSearchService.class,args);
    }

}
