package com.liucc.springcloud.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @ClassName: StreamRabbitMQListener
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: liuchuangchuang
 * @date: 2023/11/6 15:33
 * @version: V1.0
 */
@Component
@EnableBinding(Sink.class)  //开启输入端的通道  Sink：输入端
@Slf4j
public class StreamRabbitMQListener {

    @Value("${server.port}")
    String serverPort;
    @StreamListener(Sink.INPUT)     // 监听通道是否有新消息产生
    public void getMessage(Message<String> message){
        String data = message.getPayload();
        log.info("****消息数据是：{}, port:{}", data, serverPort);
    }
}
