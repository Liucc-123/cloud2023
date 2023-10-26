package com.liucc.springcloud.feign;

import org.springframework.stereotype.Component;

/**
 * @InterfaceName: PaymentFeignFallback
 * @Description: 当feign客户端调用出现异常，就返回本类的方法作为服务降级
 * @author: liuchuangchuang
 * @date: 2023/10/26 14:12
 * @version: V1.0
 */
@Component
public class PaymentFeignFallback implements PaymentFeign{
    public String paymentOK(String id) {
        return "PaymentFeignFallback---------paymentOK接口出错/(ㄒoㄒ)/~~";
    }

    public String paymentTimeOut(String id) {
        return "PaymentFeignFallback---------paymentTimeOut接口出错/(ㄒoㄒ)/~~";
    }
}
