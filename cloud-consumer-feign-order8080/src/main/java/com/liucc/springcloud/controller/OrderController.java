package com.liucc.springcloud.controller;

import com.liucc.springcloud.common.CommonResult;
import com.liucc.springcloud.entity.Payment;
import com.liucc.springcloud.feign.PaymentFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: OrderController
 * @description:
 * @author: liucc
 * @create: 2020/3/5 21:18
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    @Autowired
    private PaymentFeign paymentFeign;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeign.getPayment(id);
    }
}
