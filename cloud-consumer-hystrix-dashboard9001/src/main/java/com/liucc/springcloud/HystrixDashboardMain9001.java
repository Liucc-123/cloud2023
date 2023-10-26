package com.liucc.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableHystrixDashboard 	// 开启Hystrix图形化监控
public class HystrixDashboardMain9001 {
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardMain9001.class, args);
	}
}
