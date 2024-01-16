package com.ind.lms.config;

import com.ind.lms.services.implementation.BooksApplicationService;
import com.ind.lms.services.interfaces.IBooksApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationServiceConfig {
    @Bean
    public IBooksApplicationService iBooksApplicationService(){
        return new BooksApplicationService();
    }
}
