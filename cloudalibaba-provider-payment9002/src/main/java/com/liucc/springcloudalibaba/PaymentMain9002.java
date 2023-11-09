package com.liucc.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: PaymentMain9001
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: liuchuangchuang
 * @date: 2023/11/9 17:45
 * @version: V1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9002
{
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9002.class, args);
    }
}
