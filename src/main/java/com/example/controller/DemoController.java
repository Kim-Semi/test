package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.DemoService;

@Controller
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    
    @Autowired
    private DemoService service;
    
    @GetMapping("/hello")
    public String demo() {
        
        String id = service.id();
        
        logger.debug("#### HELLO!!!! -> id:{} ####", id);
        
        return "hello";
    }
    
	@GetMapping("/helloS")
	public String demo1(Model model, @RequestParam String info_id, @RequestParam String info_pw) {

	    logger.debug("#### HELLO!!!! ####");
		
		model.addAttribute("demo", "yes demo");
		
		return "hello";
	}
	
	
	@GetMapping("/helloM")
	public ModelAndView demo2(HttpServletRequest request, @RequestParam String info_id, @RequestParam String info_pw) {

	    logger.debug("#### HELLO!!!! ####");
		
		ModelAndView mav = new ModelAndView("hello");

		mav.addObject("demo", "yes demo"); // req로 던져질 값
		
		return mav;
	}
	
}
