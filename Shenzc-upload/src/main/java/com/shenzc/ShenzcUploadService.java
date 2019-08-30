package com.shenzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shenzc
 * @create 2019-08-30-10:19
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ShenzcUploadService {

    public static void main(String[] args) {
        SpringApplication.run(ShenzcUploadService.class,args);
    }

}
