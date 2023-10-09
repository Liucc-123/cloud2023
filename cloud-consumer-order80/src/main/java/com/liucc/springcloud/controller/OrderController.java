package com.liucc.springcloud.controller;

import com.liucc.springcloud.common.CommonResult;
import com.liucc.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: OrderController
 * @description:
 * @author: liucc
 * @create: 2020/3/5 21:18
 **/
@RestController
@Slf4j
public class OrderController {

//    private final static String PAYMENT_URL = "http://localhost:8001";//不集群
    private final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment";//集群

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/getPayment/" + id, CommonResult.class, id);
    }

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/create", payment, CommonResult.class);
    }


}
