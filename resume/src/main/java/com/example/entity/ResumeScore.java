package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Comparator;

/**
 * @作者: 曾朝阳
 * @日期: 2020/1/3 21:36
 * @内容:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resume_score")
public class ResumeScore implements Serializable{
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "score")
    private Integer score;


}
