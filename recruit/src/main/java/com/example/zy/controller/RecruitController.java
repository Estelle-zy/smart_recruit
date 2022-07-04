package com.example.zy.controller;

import com.example.ResponseResult;
import com.example.zy.entity.RecruitInfo;
import com.example.zy.service.impl.RecruitServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/22 20:36
 * @内容:
 */
@Controller
@RequestMapping("/api/recruit")
public class RecruitController {
    @Autowired
    private RecruitServiceImpl service;

    @GetMapping("/queryAll")
    @ResponseBody
    public ResponseResult queryAll(@RequestParam(defaultValue = "1") int pageNum,
                                   @RequestParam(defaultValue = "2") int pageSize){
        PageInfo<RecruitInfo> info = service.queryAll(pageNum, pageSize);
        return new ResponseResult(200,"",info);
    }
}
