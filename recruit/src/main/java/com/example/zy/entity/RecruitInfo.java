package com.example.zy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/22 20:21
 * @内容:
 */
@Data
@Table(name = "recruit_info")
@AllArgsConstructor
@NoArgsConstructor
public class RecruitInfo implements Serializable {
    @Id
    @Column(name = "company_id")
    private  Integer id;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;


}
