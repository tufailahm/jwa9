package com.training.jwa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/home")	//http://localhost:9090/home
	public String home() {
		return "--Hello and Warm Welcome to JWA PRIMER Session-- Revature";
	}
	
}