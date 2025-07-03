package com.study.demo01.service;

import com.study.demo01.entity.OperationLog;
import com.study.demo01.mapper.OperationLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OperationLogService {
    
    @Autowired
    private OperationLogMapper operationLogMapper;

    @Async
    public void saveLog(OperationLog log) {
        operationLogMapper.insert(log);
    }
}