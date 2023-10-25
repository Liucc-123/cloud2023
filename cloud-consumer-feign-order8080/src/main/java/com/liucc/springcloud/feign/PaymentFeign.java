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
@FeignClient("CLOUD-PAYMENT-SERVICE")
@Component
@RequestMapping("/payment")
public interface PaymentFeign {

    @GetMapping("/getPayment/{id}")
    CommonResult getPayment(@PathVariable("id") Long id);

    @GetMapping("/feign/timeout")
    String getFeignTimeOut();
}
