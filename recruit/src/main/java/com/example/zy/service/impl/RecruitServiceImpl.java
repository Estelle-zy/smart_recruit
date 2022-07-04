package com.example.zy.service.impl;

import com.example.zy.entity.RecruitInfo;
import com.example.zy.mapper.RecruitMapper;
import com.example.zy.service.RecruitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/22 20:35
 * @内容:
 */
@Service
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    private RecruitMapper mapper;
    @Override
    public PageInfo<RecruitInfo> queryAll(int pageNum, int size) {
        PageHelper.startPage(pageNum, size);
        List<RecruitInfo> list = mapper.selectAll();
        PageInfo<RecruitInfo> info = new PageInfo<>(list);
        return info;
    }
}
