package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/23 22:06
 * @内容:简历
 */
@Data
@Table(name = "resume_info")
public class ResumeInfo implements Serializable {
    @Id
    @Column(name = "userid")
    private Integer id;

    @Column(name = "actual_name")
    private String name;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "graduate_school")
    private String school;

    @Column(name = "awards")
    private String awards;

    @Column(name = "introduce")
    private String introduce;

    @Column(name = "experience")
    private String experience;

}
