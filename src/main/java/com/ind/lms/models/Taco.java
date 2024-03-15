package com.ind.lms.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;


/**
 *
 */
@Data
@Builder
public class Taco {
    private final String id;
    private final String name;

    private final List<Ingredient> ingredientList;
}
