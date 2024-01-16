package com.ind.lms.services.implementation;

import com.ind.lms.entity.Book;
import com.ind.lms.services.interfaces.IPricingService;
import com.ind.lms.services.interfaces.ITaxationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscountedPricingServices implements IPricingService {

    private final Logger logger = LoggerFactory.getLogger(DiscountedPricingServices.class);
    private final ITaxationService iTaxationService;

    public DiscountedPricingServices(ITaxationService iTaxationService) {
        this.iTaxationService = iTaxationService;
    }

    @Override
    public String getPrice(Book book) {

        logger.info("Using {}", iTaxationService.getClass().getSimpleName());

       // if (book.getPublicationAddress()!= null && book.getPublicationAddress().getState().equalsIgnoreCase("MP"))
        //    return "100";
        return null;
    }
}
