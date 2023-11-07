package com.liucc.springcloud.controller;

import com.liucc.springcloud.listener.StreamRabbitMQListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: StreamMQController
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: liuchuangchuang
 * @date: 2023/11/6 15:46
 * @version: V1.0
 */
@RestController
@Slf4j
public class StreamMQController {

    @Autowired
    private StreamRabbitMQListener listener;
    @GetMapping("/getMsg")
    public String getMsg(Message<String> message){
         listener.getMessage(message);
         return "success";
    }
}
