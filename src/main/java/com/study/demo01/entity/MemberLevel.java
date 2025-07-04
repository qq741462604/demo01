package com.study.demo01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberLevel {
    private Long id;
    private String levelName;
    private String levelCode;
    private BigDecimal discountRate;
    private Integer pointsThreshold;
    private String description;
    private Date createTime;
    private Date updateTime;
}