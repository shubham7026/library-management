package com.ind.lms.models;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    String message ;
    HttpStatus httpStatus;



    public ErrorResponse (){}

    public ErrorResponse (String msg, HttpStatus httpStatus){
        this.message = msg ;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
