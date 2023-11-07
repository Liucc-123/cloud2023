package com.liucc.springcloud.service;

/**
 * @InterfaceName: IMessageProvider
 * @Description: 消息生产端接口
 * @author: liuchuangchuang
 * @date: 2023/11/6 14:40
 * @version: V1.0
 */
public interface IMessageProvider {
    /**
     * 消息发送
     * @return
     */
    String sendMessage();
}
