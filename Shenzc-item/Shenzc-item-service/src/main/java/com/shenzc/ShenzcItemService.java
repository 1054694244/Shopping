package com.shenzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 婵大pig
 * @create 2019-08-21 14:47
 */
@SpringBootApplication
@EnableDiscoveryClient  //开启EurekaClient功能
public class ShenzcItemService {
    public static void main(String[] args) {
        SpringApplication.run(ShenzcItemService.class,args);
    }
}
