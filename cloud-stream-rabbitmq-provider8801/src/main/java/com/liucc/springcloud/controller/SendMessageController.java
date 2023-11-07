package com.liucc.springcloud.controller;

import com.liucc.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: SendMessageController
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: liuchuangchuang
 * @date: 2023/11/6 14:46
 * @version: V1.0
 */
@RestController
public class SendMessageController {
    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/sendMsg")
    public String sendMsg(){
        return messageProvider.sendMessage();
    }
}
