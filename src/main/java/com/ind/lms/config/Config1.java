package com.ind.lms.config;



import com.ind.lms.services.implementation.DiscountedPricingServices;
import com.ind.lms.services.implementation.DiscountedTaxationService;
import com.ind.lms.services.interfaces.IPricingService;
import com.ind.lms.services.interfaces.ITaxationService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "useOriginalService", havingValue = "false", matchIfMissing = true)
//if useOriginalService is not present in application.properties, then this configuration will be used by default (matchIfMissing = true is default)
public class Config1 {

   /* @Bean
    public ITaxationService discountedTaxationService(){
        return new DiscountedTaxationService();
    }
    @Bean
    public IPricingService discountedPricingService(){
        return new DiscountedPricingServices(discountedTaxationService());
    }*/


    /*@Bean
    StudentRestController studentRestController (){
        return new StudentRestController(discountedPricingService());
    }*/
}
