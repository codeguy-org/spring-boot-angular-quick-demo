package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@Value("${baseuri}")
	private String baseuri;

	@RequestMapping("/test")
	public String test(@RequestParam(value="test", required=false, defaultValue="test") String test, Model model) {
		model.addAttribute("test", test);
		return "test";
	}
	
	@RequestMapping("/")
	public String courses(Model model) {
		model.addAttribute("baseuri", baseuri);
		return "courses";
	}
}
