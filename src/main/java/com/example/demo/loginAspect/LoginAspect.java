package com.example.demo.loginAspect;

import com.example.demo.aop.LogExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoginAspect {
    Logger logger = Logger.getLogger("LoginAspect");
    @Pointcut("execution (* com.example.demo.service.*.*(..))")
    public void serviceMethods(){

    }

    @Before("serviceMethods()")
    public Object lookExecutionTime(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        finally {
            long duration = System.currentTimeMillis() - startTime;
            logger.info("duration > 1000 " + duration);
            if (duration > 1000) {
                logger.info("Очень долго работает");
            }
        }

    }
    @Around("annotation(logExecutionTime)")
    public Object monitorPerformance(ProceedingJoinPoint joinPoint, LogExecutionTime logExecutionTime) {
        long startTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        finally {
            long duration = System.currentTimeMillis() - startTime;
            logger.info("duration > 1000 " + duration);
            if (duration > 1000) {
                logger.info("Очень долго работает");
            }
        }
    }
}
