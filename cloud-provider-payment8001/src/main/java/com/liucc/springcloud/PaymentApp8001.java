package com.liucc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentApp8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApp8001.class, args);
    }
}
