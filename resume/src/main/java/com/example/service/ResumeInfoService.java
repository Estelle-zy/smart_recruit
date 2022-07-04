package com.example.service;

import com.example.entity.RequiredSkills;
import com.example.entity.ResumeInfo;
import com.example.entity.SkillInfo;

import java.util.List;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/23 22:15
 * @内容:
 */
public interface ResumeInfoService {
    //保存简历
    int add(ResumeInfo resumeInfo);

    //简历打分，返回简历的分数值
    int calculate(ResumeInfo resumeInfo);

    //根据id，返回该用户的所有技能
    List<SkillInfo> findByIdForSkills(int id);

    //查询所有的简历，并打分
    void queryAllAndCalculate();

    //查询所有的简历
    List<ResumeInfo> queryAll();

    //根据id，返回该用户的简历
    ResumeInfo findByIdForResume(int id);
}
