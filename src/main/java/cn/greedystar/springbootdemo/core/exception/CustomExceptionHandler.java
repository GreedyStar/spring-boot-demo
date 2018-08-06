package cn.greedystar.springbootdemo.core.exception;

import cn.greedystar.springbootdemo.common.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author GreedyStar
 * Date   2018/7/23
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public Response handleException(CustomException exception) {
        return new Response.Builder().setStatus(500).setMessage(exception.getMessage()).build();
    }

}
