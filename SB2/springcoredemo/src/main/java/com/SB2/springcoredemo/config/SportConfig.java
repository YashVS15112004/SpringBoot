package com.SB2.springcoredemo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.SB2.springcoredemo.common.Coach;
import com.SB2.springcoredemo.common.SwimCoach;

@Configuration
public class SportConfig {
    @Bean
    @Qualifier("aquatic")
    public Coach swimCoach()
    {
        return new SwimCoach();
    }
}
