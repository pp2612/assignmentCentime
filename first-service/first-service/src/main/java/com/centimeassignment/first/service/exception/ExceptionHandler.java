package com.centimeassignment.first.service.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<Object> exception(HttpMessageNotReadableException exception) {

        log.info("Entered JSON check Exception");
        return new ResponseEntity<>("Please provide a valid JSON", HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = InvalidJSONException.class)
    public ResponseEntity<Object> exception(InvalidJSONException exception) {

        log.info("Entered Null Check Exception");
        return new ResponseEntity<>("Name and Surname cannot be null", HttpStatus.BAD_REQUEST);
    }

}
