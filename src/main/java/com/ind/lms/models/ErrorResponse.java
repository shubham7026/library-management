package com.ind.lms.models;

import lombok.*;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ErrorResponse {
    String message ;
}
