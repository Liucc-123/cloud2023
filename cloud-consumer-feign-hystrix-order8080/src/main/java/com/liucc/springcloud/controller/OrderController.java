package com.liucc.springcloud.controller;

import com.liucc.springcloud.common.CommonResult;
import com.liucc.springcloud.entity.Payment;
import com.liucc.springcloud.feign.PaymentFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @GetMapping("/ok/{id}")
    public String paymentOK(@PathVariable("id")String id){
        return paymentFeign.paymentOK(id);
    }


    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            // 等待超时时间1.5s
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
    })
    @GetMapping("/timeout/{id}")
    public String paymentTimeOut(@PathVariable("id")String id){
        // 模拟自己|服务错误
//        int res = 10 / 0;
        return paymentFeign.paymentTimeOut(id);
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") String id)
    {
        return "我是消费者8080,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }
}
