package com.greedystar.sample3.config.exception;

import com.greedystar.sample3.entity.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author GreedyStar
 * Date   2020-6-11
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity handleException(CustomException exception) {
        return new ResponseEntity.Builder().setStatus(500).setMessage(exception.getMessage()).build();
    }

}
