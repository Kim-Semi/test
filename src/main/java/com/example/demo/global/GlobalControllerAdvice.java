package com.example.demo.global;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/*
 * BasicErrorController, AbstractErrorController 확인
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    protected String noHandlerFoundExceptionHandler(HttpServletRequest request, ServletException e) {
        return "";
    }

}
