package com.example.zy.controller;

import com.example.ResponseResult;
import com.example.zy.entity.CompanyInfo;
import com.example.zy.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/23 21:00
 * @内容:
 */
@Controller
@RequestMapping("/api/recruit")
public class CompanyInfoController {
    @Autowired
    private CompanyInfoService service;

    @GetMapping("/findById")
    @ResponseBody
    public ResponseResult findById(Integer id){
        return new ResponseResult(200,"",service.findById(id));
    }

}
