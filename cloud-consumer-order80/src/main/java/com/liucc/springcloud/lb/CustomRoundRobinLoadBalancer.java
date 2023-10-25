package com.liucc.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: CustomRoundRobinLoadBalancer
 * @Description: 自定义轮询负载均衡器
 * @author: liuchuangchuang
 * @date: 2023/10/25 14:14
 * @version: V1.0
 */
@Component
public class CustomRoundRobinLoadBalancer implements LoadBalancer {
    private AtomicInteger nextServerIndex = new AtomicInteger(0);
    // 计数器
    private Integer counter = 0;
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        if(serviceInstances == null || serviceInstances.size() <= 0){
            System.out.println("集群中无可用机器");
            return null;
        }
        int index = incrementAndGetModulo(serviceInstances.size());
        return serviceInstances.get(index);
    }

    /**
     * 获取所要调度的机器下标
     * @param modulo 集群中服务器的总数量
     * @return
     */
    private final int incrementAndGetModulo(int modulo){
        int current;
        int next;
        // 自旋锁+CAS
        for(;;){
            counter++;
            current = nextServerIndex.get();
            next = (current + 1) % modulo;
            if(nextServerIndex.compareAndSet(current, next)){
                System.out.println("第" + counter + "次请求：索要访问的服务实例下标是：" + next);
                return next;
            }
        }
    }
}
