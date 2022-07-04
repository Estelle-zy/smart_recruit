package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @作者: 曾朝阳
 * @日期: 2019/12/22 21:27
 * @内容:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult {
    private Integer status;
    private String message;
    private Object data;
}
