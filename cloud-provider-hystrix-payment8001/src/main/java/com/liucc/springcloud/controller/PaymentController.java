package com.liucc.springcloud.controller;

import com.liucc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: PaymentController
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: liuchuangchuang
 * @date: 2023/10/8 17:28
 * @version: V1.0
 */
@RestController
@RequestMapping("/hystrix/payment")
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/ok/{id}")
    public String paymentOK(@PathVariable("id")String id){
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/timeout/{id}")
    public String paymentTimeOut(@PathVariable("id")String id){
        return paymentService.paymentInfo_TimeOut(id);
    }
}
