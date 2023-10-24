package com.liucc.springcloud;

import com.liucc.ribbon.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName: OrderMain80
 * @description:
 * @author: XZQ
 * @create: 2020/3/5 21:14
 **/
@SpringBootApplication
@EnableEurekaClient
// 使用指定的负载均衡算法 name：要负载均衡的服务名
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8080.class, args);
    }
}
