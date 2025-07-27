package com.SB2.springcoredemo.common;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//@Primary - Multiple Beans resolve
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{


    //define init method
    // @PostConstruct
    // public void doMyStartupStuff()
    // {
    //     System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
    // }

    //define our destroy method
    // @PreDestroy
    // public void doMyCleanupStuff()
    // {
    //     System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
    // }


    public CricketCoach()
    {
        System.out.println("In Constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout()
    {
        return "Practice fast bowling for 20 minutes!!!";
    }
}
