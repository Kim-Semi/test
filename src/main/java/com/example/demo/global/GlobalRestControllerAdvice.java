package com.example.demo.global;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

/*
 * ResponseEntityExceptionHandler 확인
 */
@RestControllerAdvice
public class GlobalRestControllerAdvice {

    public static class GlobalRestException extends ResourceAccessException {

        private static final long serialVersionUID = 20190731L;

        public GlobalRestException(String msg) {
            super(msg);
        }

        public GlobalRestException(String msg, IOException ex) {
            super(msg, ex);
        }

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = { GlobalRestException.class })
    protected ResponseEntity<?> restExceptionHandler(HttpServletRequest request, ServletException e) {
        return ResponseEntity.of(null);
    }

}
