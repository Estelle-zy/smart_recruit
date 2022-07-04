package com.example.service.impl;

import com.example.entity.ResumeScore;
import com.example.mapper.ResumeScoreMapper;
import com.example.service.ResumeScoreService;
import com.example.utils.MyCompare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @作者: 曾朝阳
 * @日期: 2020/1/4 10:35
 * @内容:
 */
@Service
public class ResumeScoreServiceImpl implements ResumeScoreService {
    @Autowired
    private ResumeScoreMapper mapper;
    @Override
    public int add(ResumeScore resumeScore) {
        return mapper.insert(resumeScore);
    }

    @Override
    public List<ResumeScore> queryAll() {
        List<ResumeScore> list = mapper.selectAll();
        Collections.sort(list,new MyCompare());
        return list;
    }
}
