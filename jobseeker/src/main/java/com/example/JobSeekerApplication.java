package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/22 19:36
 * @内容:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class JobSeekerApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobSeekerApplication.class);

    }
}
