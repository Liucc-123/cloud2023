package com.liucc.springcloud.feign;

import com.liucc.springcloud.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @InterfaceName: PaymentFeign
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: liuchuangchuang
 * @date: 2023/10/25 17:50
 * @version: V1.0
 */
// @FeignClient注解表明自己是Feign客户端，调用的服务是CLOUD-PAYMENT-SERVICE
// PaymentFeignFallback是当Feign客户端调用出现错误时的降级方法
// 这种方式，使得业务方法和降级方法之间解耦
@FeignClient(value = "CLOUD-PAYMENT-SERVICE", fallback = PaymentFeignFallback.class)
@Component
public interface PaymentFeign {

    @GetMapping("/hystrix/payment/ok/{id}")
    public String paymentOK(@PathVariable("id")String id);

    @GetMapping("/hystrix/payment/timeout/{id}")
    public String paymentTimeOut(@PathVariable("id")String id);
}
