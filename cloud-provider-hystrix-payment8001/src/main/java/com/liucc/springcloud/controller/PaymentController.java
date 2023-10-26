package com.liucc.springcloud.controller;

import com.liucc.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
// 通用服务降级方法：payment_Global_FallbackMethod
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
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
    @HystrixCommand //没有指定降级方法，就是用通用降级方法
    public String paymentTimeOut(@PathVariable("id")String id){
        return paymentService.paymentInfo_TimeOut(id);
    }
    /**
     * 测试服务熔断
     * @param id
     * @return
     */
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }

    /**
     * 通用降级方法，当服务接口出现异常时，将返回方法的结果
     * @return
     */
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
