package com.ind.lms.config;



import com.ind.lms.services.interfaces.IPricingService;
import com.ind.lms.services.interfaces.ITaxationService;
import com.ind.lms.services.implementation.OriginalPricingService;
import com.ind.lms.services.implementation.OriginalTaxationService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "useOriginalService", havingValue = "true")
public class Config {


  /*  @Bean
    public ITaxationService originalTaxationService() {

        return new OriginalTaxationService();
    }

    @Bean
    public IPricingService originalPricingService() {

        return new OriginalPricingService(originalTaxationService());

    }*/


    //create bean of CustomConfigurations
    /*@Bean
    public CustomConfigurations customConfigurations(){
        return new CustomConfigurations();
    }*/
}
