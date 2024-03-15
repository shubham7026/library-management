package com.ind.lms;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;




@Slf4j
@PropertySource(value = "classpath:application.yml")
@SpringBootApplication /*these annotations include 3 more annotation
                        @SpringBootAutoConfiguration
                        @EnableAutoConfiguration
                        @ComponentScan
*/
public class LmsApplication {

    @Value("${spring.application.name}")
    private static String greeting ;
    public static void main(String[] args) {
        log.info(greeting);
        SpringApplication.run(LmsApplication.class, args);
        System.out.println(StringUtils.substringBetween("FINACTV_B2CPIA_10_1_1","_","_"));


        ;




    }
}
