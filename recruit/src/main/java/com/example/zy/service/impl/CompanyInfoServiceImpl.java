package com.example.zy.service.impl;

import com.example.zy.entity.CompanyInfo;
import com.example.zy.mapper.CompanyInfoMapper;
import com.example.zy.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/23 20:58
 * @内容:
 */
@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {
    @Autowired
    private CompanyInfoMapper mapper;
    @Override
    public CompanyInfo findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }
}
