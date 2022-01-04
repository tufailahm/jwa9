package com.training.jwa.controller;

import org.springframework.stereotype.Service;

@Service
public class Payment {

	public String pay(int amount, String customerName) {
		return "Successfully credited USD : " + amount + " to " + customerName;
	}
}
