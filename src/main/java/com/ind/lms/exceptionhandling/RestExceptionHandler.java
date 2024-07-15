package com.ind.lms.exceptionhandling;


import com.ind.lms.customexceptions.StudentNotFoundException;
import com.ind.lms.models.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> restExceptionHandler(Exception exception){

        log.error("",exception);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());

        if (exception instanceof StudentNotFoundException ex){
            errorResponse.setMessage(exception.getMessage());
            return new ResponseEntity<>(errorResponse,ex.getHttpStatus());
        }
        else if (exception instanceof TypeMismatchException ){
            errorResponse.setMessage("Incorrect Input, please provide correct input");
            return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
        }

      /*  if (exception instanceof UsernameNotFoundException){

        }*/

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

}
