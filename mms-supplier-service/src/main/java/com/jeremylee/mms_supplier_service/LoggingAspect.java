package com.jeremylee.mms_supplier_service;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Pointcut to log all public methods in controllers and services
    @Pointcut("execution(* com.jeremylee.mms_supplier_service.service..*.*(..))")
    public void applicationMethods() {
    }

    // Before advice - runs before the method execution
    @Before("applicationMethods()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Entering: {} with arguments = {}", joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()));
    }

    // After returning advice - runs after method execution (only if successful)
    @AfterReturning(pointcut = "applicationMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Exiting: {} with result = {}", joinPoint.getSignature(), result);
    }

    // After throwing advice - runs if method throws an exception
    @AfterThrowing(pointcut = "applicationMethods()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception in {}: {}", joinPoint.getSignature(), exception.getMessage());
    }
}
