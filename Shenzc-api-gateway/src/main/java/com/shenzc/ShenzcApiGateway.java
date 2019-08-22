package com.shenzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author 婵大pig
 * @create 2019-08-21 14:31
 */
@SpringBootApplication
@EnableDiscoveryClient  //开启Eureka客户端发现功能
@EnableZuulProxy    //开启zuul的网关功能
public class ShenzcApiGateway {

    public static void main(String[] args){
        SpringApplication.run(ShenzcApiGateway.class,args);
    }

}
