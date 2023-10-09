package com.liucc.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liucc.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author liuchuangchuang
* @description 针对表【payment】的数据库操作Mapper
* @createDate 2023-10-08 17:13:39
* @Entity com.liucc.springcloud.entity.Payment
*/
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
    int create(@Param("payment") Payment payment);

    Payment selectByIdPayment(@Param("id") Long id);
}




