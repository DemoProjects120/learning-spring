package com.rootnext.spring.app.advisors;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by sanjoy on 7/6/15.
 */
public class BeforeAdvisor implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Additional Concern Befor Logic");
    }
}
