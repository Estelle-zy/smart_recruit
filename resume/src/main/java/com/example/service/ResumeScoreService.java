package com.example.service;

import com.example.entity.ResumeScore;

import java.util.List;

/**
 * @作者: 曾朝阳
 * @日期: 2020/1/4 10:34
 * @内容:
 */
public interface ResumeScoreService {
    int add(ResumeScore resumeScore);

    List<ResumeScore> queryAll();
}
