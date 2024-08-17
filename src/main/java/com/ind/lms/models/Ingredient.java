package com.ind.lms.models;


import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
