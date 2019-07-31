package com.example.demo.global;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.global.GlobalRestControllerAdvice.GlobalRestException;

@RestController
public class GlobalRestController {

    @GetMapping("/api/**/*")
    public ResponseEntity<?> noResource(HttpServletRequest request) {
        throw new GlobalRestException("api 없음");
    }
    
}
