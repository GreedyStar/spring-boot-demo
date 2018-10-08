package com.greedystar.springbootdemo.core.exception;

import com.greedystar.springbootdemo.common.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author GreedyStar
 * Date   2018/7/23
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception exception) {
        exception.printStackTrace(); // 打印异常
        return new Response.Builder().setStatus(500).setMessage(exception.getMessage()).build();
    }

}
