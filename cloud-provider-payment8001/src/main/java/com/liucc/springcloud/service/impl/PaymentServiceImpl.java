package com.liucc.springcloud.service.impl;

import com.liucc.springcloud.entity.Payment;
import com.liucc.springcloud.mapper.PaymentMapper;
import com.liucc.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: PaymentServiceImpl
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: liuchuangchuang
 * @date: 2023/10/8 17:26
 * @version: V1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment selectByIdPayment(Long id) {
        return paymentMapper.selectByIdPayment(id);
    }
}
