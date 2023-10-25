package com.liucc.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @InterfaceName: LoadBalancer
 * @Description: TODO (用一句话描述该文件做什么)
 * @author: liuchuangchuang
 * @date: 2023/10/25 14:11
 * @version: V1.0
 */
public interface LoadBalancer {
    /**
     * 负载均衡，传入一个服务实例列表，返回一个服务实例
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
