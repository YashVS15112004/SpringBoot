package com.SB2.springcoredemo.common;

public class SwimCoach implements Coach {

    public SwimCoach()
    {
        System.out.println("In constructor : "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout()
    {
        return "Swim 100 mtrs as a warm up.";
    }
}
