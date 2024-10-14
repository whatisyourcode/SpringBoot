package edu.du.sb1010_2.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class SampleAspect {
    @Around("execution(* *..aop2*Greet.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around advice");
        System.out.println("처리 전");

        Object result = joinPoint.proceed();

        System.out.println("처리 후");

        return result;
    }


    @Before("execution(* *..aop2.*Greet.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before advice");

        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));

        System.out.println(String.format("메서드:%s",joinPoint.getSignature().getName()));
    }
    @After("execution(* *..aop2.*Greet.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After advice");

        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));

        System.out.println(String.format("메서드:%s",joinPoint.getSignature().getName()));
    }
}
