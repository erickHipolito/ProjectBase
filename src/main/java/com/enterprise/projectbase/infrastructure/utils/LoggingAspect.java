package com.enterprise.projectbase.infrastructure.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("@annotation(LogStartExecutionTimeEnd)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("[{}:{}] started",joinPoint.getSignature().getDeclaringType().getSimpleName(),joinPoint.getSignature().getName());
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info("[{}:{}] executed ended in {} ms. ",joinPoint.getSignature().getDeclaringType().getSimpleName(),joinPoint.getSignature().getName(),executionTime);
        return proceed;
    }
}
