package com.example.demo.global;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
 * ResponseEntityExceptionHandler 확인
 */
@RestControllerAdvice
public class GlobalRestControllerAdvice extends ResponseEntityExceptionHandler {

    public static class GlobalRestException extends ResourceAccessException {

        private static final long serialVersionUID = 20190731L;

        public GlobalRestException(String msg) {
            super(msg);
        }

        public GlobalRestException(String msg, IOException ex) {
            super(msg, ex);
        }

    }

    // 아래부터 exception class에 따라 handle 추가
    
    @ExceptionHandler(value = { GlobalRestException.class })
    protected ResponseEntity<Object> globalRestExceptionHandler(GlobalRestException ex, WebRequest request) {

        // http header 설정
        HttpHeaders headers = new HttpHeaders();
        
        // http status 설정
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        // http body 설정
        Object obj = new Object();
        
        return handleExceptionInternal(ex, obj, headers, status, request);
    }

}
