package com.ind.lms.services.implementation;

import com.ind.lms.config.CustomConfigurations;
import com.ind.lms.entity.Book;
import com.ind.lms.services.interfaces.IPricingService;
import com.ind.lms.services.interfaces.ITaxationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class OriginalPricingService implements IPricingService {

    //private final ITaxationService iTaxationService;

    @Autowired
    private CustomConfigurations customConfigurations;
    //public OriginalPricingService(ITaxationService iTaxationService) {
        //this.iTaxationService = iTaxationService;
  //  }
    private final Logger logger = LoggerFactory.getLogger(OriginalPricingService.class);


    @Override
    public String getPrice(Book book) {
       // logger.info("Using {}",iTaxationService.getClass().getSimpleName());
        logger.info("In Dewas Hospital - {}", customConfigurations.getDewas());
      //  if (book.getPublicationAddress()!= null && book.getPublicationAddress().getState().equalsIgnoreCase("MP"))
      //      return "100";
        return null;
    }
}
