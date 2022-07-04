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
 * @日期: 2019/12/23 20:33
 * @内容:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company_info")
public class CompanyInfo implements Serializable {
    @Id
    @Column(name = "company_id")
    private Integer id;

    @Column(name = "company_name")
    private String name;

    @Column(name = "introduce")
    private String introduce;

    @Column(name = "type")
    private String type;

    @Column(name = "address")
    private String address;



}
