package com.example.service.impl;
import com.example.entity.SkillInfo;
import com.example.mapper.SkillInfoMapper;
import com.example.service.SkillInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @作者: 曾朝阳
 * @日期: 2020/1/3 21:42
 * @内容:
 我们这里不再写复杂的mapper.xml文件，而是在mapper文件夹下创建对应接口，每个接口都继承通用mapper，并指定泛型
 在service实现的时候，通用mapper不用开发者手动写复杂的sql语句，而是提供了相关的方法直接调佣
 注意的是entity与数据表的字段要一致 每个实体用@Table对应数据库的表，实体的每个字段用特定的注解如@ID @Column对应数据库表字段
 */
@Service
public class SkillInfoServiceImpl implements SkillInfoService {
    @Autowired
    private SkillInfoMapper mapper;

    @Override
    public SkillInfo findById(int id) {
        return mapper.selectByPrimaryKey(id);
    }
}
