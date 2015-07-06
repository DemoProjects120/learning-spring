package com.rootnext.spring.app.advisors;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by sanjoy on 7/6/15.
 */
public class MyAdvisor implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor{
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Additional Concern Befor Logic");
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Method Completed & Returned Value");
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object obj;
        System.out.println("Before Invoke");
        obj = invocation.proceed();
        System.out.println("After Invoke");
        return obj;
    }
}
