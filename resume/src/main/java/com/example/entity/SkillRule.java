package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/23 22:45
 * @内容:
 */
@Data
@Table(name = "skill_rule")
public class SkillRule {
    @Id
    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "weight")
    private Integer weight;
}
