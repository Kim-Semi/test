package com.example.demo.global;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;

@Controller
public class GlobalController extends UrlFilenameViewController {

    @GetMapping("/**/*")
    public String urlFilenameView(HttpServletRequest request) {
        return getViewNameForRequest(request);
    }
    
}
