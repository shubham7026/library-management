package com.ind.lms.customexceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter

public class StudentNotFoundException extends RuntimeException {

    private HttpStatus httpStatus;
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
