package com.SB2.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SB2.springcoredemo.common.Coach;


@RestController
public class DemoController {
    private Coach myCoach;
    //private Coach anotherCoach;
    //Constructor Injection
    @Autowired
    public DemoController(
        @Qualifier("aquatic")Coach theCoach
        //@Qualifier("cricketCoach")Coach theanotherCoach
        )
    {
        System.out.println("In Constructor : " + getClass().getSimpleName());
        myCoach = theCoach;
        //anotherCoach = theanotherCoach;
    }

    //Setter Injection
    // @Autowired
    // public void setCoach(Coach theCoach)
    // {
    //     myCoach = theCoach;
    // }


    @GetMapping("/dailyworkout")
    public String getMethodName() {
        return myCoach.getDailyWorkout();
    }

    // @GetMapping("/check")
    // public String check()
    // {
    //     return "Comparing beans : myCoach == anotherCoach ," + (myCoach == anotherCoach);
    // }
    
}
