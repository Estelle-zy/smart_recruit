package com.example.service.impl;

import com.example.entity.*;
import com.example.mapper.ResumeInfoMapper;
import com.example.service.ResumeInfoService;
import com.example.service.ResumeScoreService;
import com.example.service.SkillInfoService;
import com.example.service.SkillRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/23 22:15
 * @内容:
 */
@Service
public class ResumeInfoServiceImpl implements ResumeInfoService {
    @Autowired
    private ResumeInfoMapper mapper;
    @Autowired
    private ResumeScoreService resumeScoreService;
    @Autowired
    private SkillInfoService skillInfoService;
    @Autowired
    private SkillRuleService skillRuleService;

    //保存简历
    @Override
    public int add(ResumeInfo resumeInfo) {
        return mapper.insert(resumeInfo);
    }

    //根据求职者id，返回该用户的所有技能
    @Override
    public List<SkillInfo> findByIdForSkills(int id) {
        List<SkillInfo> list = new ArrayList<>();
        SkillInfo skillInfo = skillInfoService.findById(id);
        list.add(skillInfo);
        return list;
    }

    //查询所有的简历
    @Override
    public List<ResumeInfo> queryAll() {
        List<ResumeInfo> list = mapper.selectAll();
        return list;
    }

    @Override
    public ResumeInfo findByIdForResume(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    //对所有的简历打分
    @Override
    public void queryAllAndCalculate() {
        List<SkillRule> skillRuleList = skillRuleService.queryAll();
        ResumeScore resumeScore = new ResumeScore();
        //1、获取所有简历
        List<ResumeInfo> list = mapper.selectAll();
        //遍历每个简历，
        for (ResumeInfo resumeInfo:list){
            //为每个简历打分
            int score = calculate(resumeInfo);
            //然后把简历分数存入数据库
            resumeScore.setId(resumeInfo.getId());
            resumeScore.setScore(score);
            resumeScoreService.add(resumeScore);
        }
    }

    //简历打分
    @Override
    public int calculate(ResumeInfo resumeInfo) {
        //得到该招聘的一个技能规则表（包含技能名称和技能比重）
        List<SkillRule> skillRuleList =skillRuleService.queryAll();

        //得到求职者技能列表，（包含技能名称和熟悉程度）
        List<SkillInfo> skillList = findByIdForSkills(resumeInfo.getId());

        //得到技能规则表中的技能点
        List<String> skillRuleName = skillRuleList
                .stream()
                .map(SkillRule::getSkillName)
                .collect(Collectors.toList());

        //得到求职者技能点
        List<String> skillListName = skillList
                .stream()
                .map(SkillInfo::getSkillName)
                .collect(Collectors.toList());

        //得到求职者技能与技能规则表技能的交集
        List<String> intersection = skillRuleName
                .stream()
                .filter(skillListName::contains)
                .collect(Collectors.toList());

        // 生成技能规则表的映射
        Map<String, Integer> RuleMap = skillRuleList
                .stream()
                .collect(Collectors.toMap(SkillRule::getSkillName, SkillRule::getWeight));

		// 生成求职者技能点的映射
        Map<String, Integer> resumeMap = skillList
                .stream()
                .collect(Collectors.toMap(SkillInfo::getSkillName, SkillInfo::getLevel));
		
		//对技能规则表中各个技能点比重求总和(不一定是100，所以需要求一下所有weight加起来的和),SkillRule::getWeight就是遍历这个skillRuleList，get他们的weight
        int ruleSum = skillRuleList
                .stream()
                .mapToInt(SkillRule::getWeight)
                .sum();
		
        // 求交集在技能规则表映射中占得和
        int getRuleSum = intersection
                .stream()
                .mapToInt(RuleMap::get)
                .sum();
		
		// 求交集在求职者技能映射中占得和
        int getResumeSum = intersection
                .stream()
                .mapToInt(resumeMap::get)
                .sum();

        // 规则表映射和  与  规则表和  比例
        double percent1 = (double) getRuleSum / ruleSum;

        // 技能交集总和：这里按照最高level来计算求职者的交集技能的掌握程度
        int sum = intersection.size() * 4;

        // 求职者技能映射和 与 技能交集和  比例
        double percent2 = (double) getResumeSum / sum;

        return (int) Math.round(percent2 * percent1 * 100);
    }
}
