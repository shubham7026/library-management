package com.ind.lms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


//@PropertySource(value = "classpath:application.yml")
//@SpringBootApplication /*these annotations include 3 more annotation
    //                    @SpringBootConfiguration
      //                  @EnableAutoConfiguration
        //                @ComponentScan
//*/
@EnableAutoConfiguration
@PropertySource(value = "classpath:application.yml")
@ComponentScan
public class LmsApplication {


    public static void main(String[] args) {
        System.out.println("Scanning starts....");
        SpringApplication.run(LmsApplication.class, args);
    }
}

