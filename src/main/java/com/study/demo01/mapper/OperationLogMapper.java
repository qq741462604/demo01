package com.study.demo01.mapper;

import com.study.demo01.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationLogMapper {
    int insert(OperationLog log);
}