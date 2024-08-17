package com.ind.lms.config;


import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString


@ConfigurationProperties(prefix = "com.lms")
public class LMSConfigurations {
    private String demoProperty;

    @PostConstruct
    public void postConstruct(){
        System.out.println("LMSConfigurations " + this.demoProperty);
    }
}
