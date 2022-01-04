package com.training.jwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	Payment payment;
	
	@RequestMapping("/home")	//http://localhost:9090/home
	public String home() {
		return "Hello and Warm Welcome to JWA Primer Session";
	}
	
	@RequestMapping("/pay/{amount}/{customerName}")		//http://localhost:9090/pay/54000/richard
	public String pay(@PathVariable("amount")int amount,@PathVariable("customerName")String customerName) {
		//Null pointer exception
		return payment.pay(amount,customerName);
		
	}
}