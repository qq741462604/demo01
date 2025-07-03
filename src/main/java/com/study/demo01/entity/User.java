package com.study.demo01.entity;

import com.study.demo01.config.StringListTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String email;
    private String username;        // 用户名
    private String password;        // 密码
    private String role;            // 角色
    private List<String> permissions; // 权限列表
    private Integer status;         // 账号状态：0-禁用，1-启用
    private Date createTime;        // 创建时间
    private Date updateTime;        // 更新时间
    private String lastLoginIp;     // 最后登录IP
    private Date lastLoginTime;     // 最后登录时间



}