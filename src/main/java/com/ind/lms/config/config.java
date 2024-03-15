package com.ind.lms.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("HI, All");
        };
    }
}
