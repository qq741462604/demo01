package com.study.demo01.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OperationLog {
    private Long id;
    private String method;        // 请求方法名
    private String path;          // 请求路径
    private String ip;            // 请求IP
    private String params;        // 请求参数
    private String result;        // 返回结果
    private Long executionTime;   // 执行时间(毫秒)
    private LocalDateTime createTime; // 创建时间
}