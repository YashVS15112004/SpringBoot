package com.luv2code.springboot.thymeleafdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
    // setup logger
    private Logger mylogger = Logger.getLogger(getClass().getName());

    // setup pointcut declaration
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint)
    {
        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        mylogger.info("=====>>>>> In @Before : calling method : " + theMethod);

        // display the arguments to the method
        // get the args
        Object[] args = theJoinPoint.getArgs();

        // loop thru the display args
        for(Object tempObject : args)
        {
            mylogger.info("=====>>>>> argument : " + tempObject);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(
        pointcut = "forAppFlow()",
        returning = "theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint,Object theResult)
    {
        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        mylogger.info("=====>>>>> In @AfterReturning : calling method : " + theMethod);

        // display the data
        mylogger.info("=====>>>>> Result : " + theResult);
    }
}
