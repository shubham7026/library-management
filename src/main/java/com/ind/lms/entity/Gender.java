package com.ind.lms.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Gender {
    MALE("Male"), FEMALE("Female") ;

    private final String gender ;

    Gender(String gender) {
        this.gender = gender;
    }

    @JsonCreator
    public static Gender fromValue(String text) {
        for (Gender b : Gender.values()) {
            if (String.valueOf(b.gender).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
