package com.example;

import com.example.entity.ResumeInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/22 19:45
 * @内容:
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.example.mapper")
@RestController
public class ResumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResumeApplication.class);
    }
}
