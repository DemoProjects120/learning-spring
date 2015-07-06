package com.rootnext.spring.app.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by sanjoy on 7/6/15.
 */
@Component
@Aspect
public class MyDemoAspect {

    @Pointcut("execution(* *(..))")
    public void allMethods(){};

    @Before("allMethods()")
    public void beforAllExecution(JoinPoint joinPoint){
        System.out.println("A Method is about to be executed");
    }

    @After("allMethods()")
    public void afterAllExecution(JoinPoint joinPoint){
        System.out.println("A Method has been executed");
    }

    @Around("allMethods()")
    public Object aroundAllExecution(ProceedingJoinPoint joinPoint) throws Throwable{

        System.out.println("Before Point");
        Object object = joinPoint.proceed();
        System.out.println("After Point");
        return object;
    }
}
