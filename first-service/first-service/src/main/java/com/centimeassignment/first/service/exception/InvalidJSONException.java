package com.centimeassignment.first.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidJSONException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public InvalidJSONException(String message) {
        super(message);
    }

    public InvalidJSONException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
