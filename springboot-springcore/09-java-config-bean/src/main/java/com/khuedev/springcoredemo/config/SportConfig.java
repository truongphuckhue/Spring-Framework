package com.khuedev.springcoredemo.config;

import com.khuedev.springcoredemo.common.Coach;
import com.khuedev.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("bananaCoachWellSwim")
    public Coach swimCoachBro(){
        return new SwimCoach();
    }
}
