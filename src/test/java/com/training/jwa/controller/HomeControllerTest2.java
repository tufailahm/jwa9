package com.training.jwa.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HomeControllerTest2 {

	@LocalServerPort
	private String port;
	
	private String baseURL="http://localhost";
	
	private URL url;
	
	@BeforeEach
	void setUp() throws Exception {
		url = new URL(baseURL+":"+port+"/home");
	}
	
	@Autowired
	RestTemplate restTemplate;

	@Test
	void testHome() {
		ResponseEntity<String> response = restTemplate.getForEntity(url.toString(), String.class);
		String expected = "--Hello and Warm Welcome to JWA PRIMER Session-- Revature";
		String actual = response.getBody();
		assertEquals(expected, actual);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}


	@AfterEach
	void tearDown() throws Exception {
	}

}
