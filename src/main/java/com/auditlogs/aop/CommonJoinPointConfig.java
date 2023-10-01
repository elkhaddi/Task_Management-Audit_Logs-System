package com.auditlogs.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
    @Pointcut("execution(* com.auditlogs.task.TaskService.*(..))")
    public void businessLayerExecution(){}
    @Pointcut("@args(org.springframework.web.bind.annotation.PathVariable)")
    public void controllerLayerExecution(){}

    @Pointcut("execution(* com.auditlogs.task.TaskController.*(..))")
    public void ofThisClass(){}
}
