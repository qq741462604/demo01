package com.study.demo01.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.demo01.entity.OperationLog;
import com.study.demo01.service.OperationLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperationLogService operationLogService;

    @Autowired
    private ObjectMapper objectMapper;

    @Pointcut("execution(* com.study.demo01.controller..*.*(..))")  // 拦截所有controller包下的方法
    public void operationLog() {}

    @Around("operationLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        
        // 获取请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 执行原方法
        Object result = joinPoint.proceed();
        
        // 记录日志
        OperationLog log = new OperationLog();
        log.setMethod(joinPoint.getSignature().getName());
        log.setPath(request.getRequestURI());
        log.setIp(getIpAddress(request));
        log.setParams(objectMapper.writeValueAsString(joinPoint.getArgs()));
        log.setResult(objectMapper.writeValueAsString(result));
        log.setExecutionTime(System.currentTimeMillis() - startTime);
        log.setCreateTime(LocalDateTime.now());

        // 异步保存日志
        operationLogService.saveLog(log);
        
        return result;
    }

    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}