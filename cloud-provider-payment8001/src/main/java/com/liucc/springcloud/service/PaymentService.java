package com.liucc.springcloud.service;

import com.liucc.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @InterfaceName: PaymentService
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: liuchuangchuang
 * @date: 2023/10/8 17:15
 * @version: V1.0
 */
public interface PaymentService {
    int create(Payment payment);

    Payment selectByIdPayment( Long id);
}
