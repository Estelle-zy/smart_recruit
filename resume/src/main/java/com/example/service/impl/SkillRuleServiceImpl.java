package com.example.service.impl;

import com.example.entity.SkillRule;
import com.example.mapper.SkillRuleMapper;
import com.example.service.SkillRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @作者: 曾朝阳
 * @日期: 2020/1/4 10:45
 * @内容:
 */
@Service
public class SkillRuleServiceImpl implements SkillRuleService {
    @Autowired
    private SkillRuleMapper mapper;
    @Override
    public List<SkillRule> queryAll() {
        return mapper.selectAll();
    }
}
