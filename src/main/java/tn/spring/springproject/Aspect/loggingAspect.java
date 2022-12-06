package tn.spring.springproject.Aspect;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class loggingAspect {

    @After("execution(* tn.spring.springproject.services.*.add*(..))")
    public void logMethodEntry1(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info("added successfuly " + name + " : ");
    }

    @Before("execution(* tn.spring.springproject.services.*.*(..))")
    public  void logMethodEntry2(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @AfterReturning(" execution(* tn.spring.springproject.services.*.add*(..))")
    public void LogMethodShow(JoinPoint joinPoint){
        log.info("Ajouté!");
    }
}
