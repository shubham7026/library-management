package com.ind.lms.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


//@ConfigurationProperties(prefix = "city")

public class CustomConfigurations {

    @Value("${dewas}")
    private String dewas;

    @Value("${indore}")
    private String indore;

    @Value("${bhopal}")
    private String bhopal;

    @Value("${ujjain}")
    private String ujjain;

    public String getDewas() {
        return dewas;
    }

    public void setDewas(String dewas) {
        this.dewas = dewas;
    }

    public String getIndore() {
        return indore;
    }

    public void setIndore(String indore) {
        this.indore = indore;
    }

    public String getBhopal() {
        return bhopal;
    }

    public void setBhopal(String bhopal) {
        this.bhopal = bhopal;
    }

    public String getUjjain() {
        return ujjain;
    }

    public void setUjjain(String ujjain) {
        this.ujjain = ujjain;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("dewas: " + dewas);
        System.out.println("indore: " + indore);
        System.out.println("ujjain: " + ujjain);
        System.out.println("bhopal: " + bhopal);

    }

}
