package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	@GetMapping("/helloS")
	public String demo1(Model model, @RequestParam String info_id, @RequestParam String info_pw) {

		System.out.println("#### HELLO!!!! ####");
		
		model.addAttribute("demo", "yes demo");
		
		return "hello";
	}
	
	
	@GetMapping("/helloM")
	public ModelAndView demo2(HttpServletRequest request, @RequestParam String info_id, @RequestParam String info_pw) {

		System.out.println("#### HELLO!!!! ####");
		
		ModelAndView mav = new ModelAndView("hello");

		mav.addObject("demo", "yes demo"); // req로 던져질 값
		
		return mav;
	}
}
