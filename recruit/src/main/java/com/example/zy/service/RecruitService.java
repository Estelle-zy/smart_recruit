package com.example.zy.service;

import com.example.zy.entity.RecruitInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/22 20:34
 * @内容:
 */
public interface RecruitService {
    PageInfo<RecruitInfo> queryAll(int pageNum, int size);
}
