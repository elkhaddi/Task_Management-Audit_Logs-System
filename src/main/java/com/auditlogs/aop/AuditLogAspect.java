package com.auditlogs.aop;

import com.auditlogs.task.NoSuchElementFoundException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AuditLogAspect {
    @Before("com.auditlogs.aop.CommonJoinPointConfig.businessLayerExecution()")
    public void beforeMethodExecution(JoinPoint joinPoint){
        log.info("Before executing method: {}",joinPoint.getSignature());
    }

    @After("com.auditlogs.aop.CommonJoinPointConfig.businessLayerExecution()")
    public void afterMethodCall(JoinPoint joinPoint){
        log.info("Method called: {}",joinPoint.getSignature());
    }

    @AfterReturning(value = "com.auditlogs.aop.CommonJoinPointConfig.controllerLayerExecution() && com.auditlogs.aop.CommonJoinPointConfig.ofThisClass()", returning = "result")
    public void afterReturningResult(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        log.info("{} returned with value {}",methodName,result);
    }

    @AfterThrowing(value = "com.auditlogs.aop.CommonJoinPointConfig.businessLayerExecution()",throwing = "exception")
    public void handleException(JoinPoint joinPoint, NoSuchElementFoundException exception){
        String methodName = joinPoint.getSignature().getName();
        log.error("Exception thrown in method : {}",methodName);
        log.error("Exception message : {}",exception.getMessage());
    }

    @Around(value = "com.auditlogs.aop.CommonJoinPointConfig.businessLayerExecution()")
    public void AroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        try {
            // proceed the actual method execution
            joinPoint.proceed();
            long timeTaken = System.currentTimeMillis()-startTime;
            String methodName = joinPoint.getSignature().getName();
            // After method execution (if it succeeds)
            log.info("Time Taken by method {} is {}",methodName,timeTaken);
        }catch (NoSuchElementFoundException e){
            String methodName = joinPoint.getSignature().getName();
            // Handle exceptions thrown during method execution
            log.error("Exception thrown in method : {}",methodName);
            log.error("Exception message : {}",e.getMessage());
        }
    }
}
