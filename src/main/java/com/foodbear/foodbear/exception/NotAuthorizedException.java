package com.foodbear.foodbear.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class NotAuthorizedException extends RuntimeException{

        @Serial
        private static final long serialVersionUID = 1L;

    public NotAuthorizedException(String message){
        super(message);
    }

}
