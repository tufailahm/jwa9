package com;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
/*
 * Sets up default configuration
 * Starts spring application context
 * Performs class path scan
 * Starts Tomcat server
 */
public class ProductappJwaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ProductappJwaApplication.class, args);
		String beans[] = ctx.getBeanDefinitionNames();
		Arrays.sort(beans);
		
		for(String beanNames:beans) {
			System.out.println(beanNames);
		}
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
