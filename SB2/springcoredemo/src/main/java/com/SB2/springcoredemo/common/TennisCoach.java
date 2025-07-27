package com.SB2.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements  Coach{

    public TennisCoach()
    {
        System.out.println("In Constructor : " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout()
    {
        return "Spend 30 minutes on your practice.";
    }
}
