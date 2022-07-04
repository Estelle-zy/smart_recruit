package com.example.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/22 21:10
 * @内容:
 在微服务中，远程服务调用都需要负载均衡，RestTemplate是一个http请求工具，我们在使用RestTemplate作为客户端的时候
 只需要加上一个注解就@LoadBalanced可以开启负载均衡了，此外该注解还可以区分多个相同名字的微服务
 他主要是通过服务的具体ip地址和服务逻辑名的一个转换来实现的
 */
@Configuration
public class BeanConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
