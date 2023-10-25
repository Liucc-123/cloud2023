package com.liucc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: OrderMain80
 * @description:
 * @author: XZQ
 * @create: 2020/3/5 21:14
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderFeignMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain8080.class, args);
    }
}
