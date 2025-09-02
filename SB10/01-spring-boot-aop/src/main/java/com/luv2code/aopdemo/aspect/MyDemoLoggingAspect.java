package com.luv2code.aopdemo.aspect;

import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect 
@Component
public class MyDemoLoggingAspect {
	
    @Before("execution(public void addAccount())")
    public void beforeAddAcountAdvice()
    {
        System.out.println("\n===>>> Executing @Before advice on addAccount()");
    }

}
