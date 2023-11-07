package com.liucc.springcloud.service.impl;

import com.liucc.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @ClassName: IMessageProviderImpl
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: liuchuangchuang
 * @date: 2023/11/6 14:41
 * @version: V1.0
 */
@EnableBinding(Source.class)    //开启消息输出管道定义 Source表示输出
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {
    @Autowired
    private MessageChannel output;
    @Override
    public String sendMessage() {
        String serial = UUID.randomUUID().toString();
        // 组装消息内容并发送
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("*****serial:{}", serial);
        return serial;
    }
}
