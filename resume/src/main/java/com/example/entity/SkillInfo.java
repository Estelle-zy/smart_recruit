package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/23 22:49
 * @内容:
 */
@Data
@Table(name = "skill_info")
public class SkillInfo implements Serializable {

    @Id
    @Column(name = "userid")
    private Integer id;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "level")
    private Integer level;

}
