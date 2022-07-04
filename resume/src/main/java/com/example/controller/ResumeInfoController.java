package com.example.controller;

import com.example.ResponseResult;
import com.example.entity.ResumeInfo;
import com.example.service.ResumeScoreService;
import com.example.service.impl.ResumeInfoServiceImpl;
import com.example.service.impl.ResumeScoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/23 22:17
 * @内容:
 */
@Controller
@RequestMapping("/api/resume")
public class ResumeInfoController {
    @Autowired
    private ResumeInfoServiceImpl service;
    @Autowired
    private ResumeScoreServiceImpl service2;

    @PostMapping("/addResume")
    @ResponseBody
    /**
     * 对于表单中提交过来的数据，我们用一个对象来接受，前提是：表单中的name的值必须和对象的属性名一致
     * 对于用户提交过来的简历，平台首先智能计算一下简历与招聘信息的契合度，（即我们的简历打分），进行一个筛选
     * 然后再把简历保存到数据库中
     */
    public ResponseResult add(ResumeInfo resumeInfo) {
        return new ResponseResult(200, "", service.add(resumeInfo));
    }

    //显示所有简历
    @GetMapping("queryAll")
    @ResponseBody
    public ResponseResult queryAll() {
        return new ResponseResult(200, "", service.queryAll());
    }


    //显示所有简历分数
    @GetMapping("queryAll2")
    @ResponseBody
    public ResponseResult queryAll2(){
        service.queryAllAndCalculate();
        return  new ResponseResult(200,"",service2.queryAll());
    }

    //查看某一个具体简历
    @GetMapping("/findDetail")
    @ResponseBody
    public ResponseResult findDetail(int id){
        return new ResponseResult(200,"",service.findByIdForResume(id));
    }






















}
