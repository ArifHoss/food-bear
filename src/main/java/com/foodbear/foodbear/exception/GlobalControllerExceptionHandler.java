package com.foodbear.foodbear.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException notFoundException, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), notFoundException.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ConflictException.class)
    protected ResponseEntity<?> conflictException(ConflictException conflictException, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), conflictException.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotAuthorizedException.class)
    protected ResponseEntity<?> notAuthorizedException(NotAuthorizedException notAuthorizedException, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), notAuthorizedException.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }
}
