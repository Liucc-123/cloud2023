package com.liucc.springcloud.controller;

import com.liucc.springcloud.common.CommonResult;
import com.liucc.springcloud.entity.Payment;
import com.liucc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: PaymentController
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: liuchuangchuang
 * @date: 2023/10/8 17:28
 * @version: V1.0
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result > 0){
            return new CommonResult<Payment>(200, "success");
        }else {
            return new CommonResult<Payment>(444, "error");
        }
    }

    @GetMapping("/getPayment/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        Payment result = paymentService.selectByIdPayment(id);
        if(result != null){
            return new CommonResult<Payment>(200, "success，端口是：" + port, result);
        }else {
            return new CommonResult<Payment>(444, "查询结果不存在：查询id："+ id + "，端口是：" + port);
        }
    }

    @GetMapping("/lb")
    public String getServerPort(){
        return port;
    }
}
