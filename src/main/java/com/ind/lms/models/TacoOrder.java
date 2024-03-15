package com.ind.lms.models;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TacoOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private List<Taco> tacos;
}
