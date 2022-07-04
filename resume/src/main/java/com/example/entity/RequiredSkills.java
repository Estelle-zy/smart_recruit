package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/23 22:42
 * @内容:
 */
@Data
@Table(name = "required_skills")
public class RequiredSkills implements Serializable {

    @Id
    @Column(name = "company_id")
    private Integer id;

    @Column(name = "skill_list")
    private List<SkillRule> skillList;

}
