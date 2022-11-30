package tn.spring.springproject.Aspect;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class loggingAspect {

    @After("execution(* tn.spring.springproject.services.*.add*(..))")
    public void logMethodEntry(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info("added successfuly " + name + " : ");
    }
    //nesta3mlo haja bel @before w calcul de tempes execution

}
