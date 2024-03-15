package com.ind.lms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Person {
    private String name ;
    private String email;
    private String phoneNo;

}
