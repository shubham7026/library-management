package com.ind.lms.exceptionhandling;


import com.ind.lms.customexceptions.StudentNotFoundException;
import com.ind.lms.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> restExceptionHandler(Exception exception){

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());

        if (exception instanceof StudentNotFoundException ){
            return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }

      /*  if (exception instanceof UsernameNotFoundException){

        }*/

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

}
