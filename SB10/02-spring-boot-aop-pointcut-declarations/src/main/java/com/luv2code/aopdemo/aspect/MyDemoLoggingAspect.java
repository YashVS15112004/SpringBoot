package com.luv2code.aopdemo.aspect;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect 
@Component
@Order(2)
public class MyDemoLoggingAspect {
    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
        pointcut = "execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
        returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account> result)
    {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturing on method : " + method);

        // print out the results of the method called
        System.out.println("\n=====>>> Result is: " + result);

        // post-process the data
        convertAccountnamesToUpperCase(result);

        System.out.println("\n=====>>> Result is: " + result);

    }

    private void convertAccountnamesToUpperCase(List<Account> result) {
        for(Account tempAccount : result)
        {
            String name = tempAccount.getName().toUpperCase();
            tempAccount.setName(name);
        }
    }

    @Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAcountAdvice(JoinPoint theJoinPoint)
    {
        System.out.println("\n===>>> Executing @Before advice on method");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        //display method arguments
        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for(Object tempArg : args)
        {
            System.out.println(tempArg);
            if(tempArg instanceof Account)
            {
                // downcast and print acc specific stuff
                Account theAccount = (Account) tempArg;
                System.out.println("account name : " + theAccount.getName());
                System.out.println("account level : " + theAccount.getLevel());
            }
        }
    }
}
 