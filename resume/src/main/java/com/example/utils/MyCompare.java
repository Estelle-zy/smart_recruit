package com.example.utils;

import com.example.entity.ResumeScore;

import java.util.Comparator;

/**
 * @作者: 曾朝阳
 * @日期: 2020/1/4 15:48
 * @内容:
 */
public class MyCompare implements Comparator<ResumeScore> {

    @Override
    public int compare(ResumeScore o1, ResumeScore o2) {
        return o1.getScore()-o2.getScore()>0?-1:1;
    }
}
