package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author
 * @Date 2022/5/24 21:24
 * @Version 1.0
 * @Description 在controller里写一个访问日志接口的方法
 **/

@RestController
@RequestMapping("/api/aop")
public class AopUserController {
    @GetMapping("/getUserByName")
    public String name(@RequestParam("name") String name) {
        return "Hello：" + name;
    }

    @GetMapping("/getUserList")
    public List<String> getUser() {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        return list;
    }
}

