package com.hc360.drools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.hc360.drools")
@EnableDiscoveryClient
@EnableCaching
@EnableFeignClients
public class DroolsSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroolsSpringbootApplication.class, args);
	}

}
