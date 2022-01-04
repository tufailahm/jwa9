package com.training.jwa.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product") // localhost:9090/product
public class ProductController {

	@PostMapping
	public String saveProduct() {
		return "Saving Product";
	}

	@PutMapping
	public String updateProduct() {
		return "Update Product";
	}

	@DeleteMapping
	public String deleteProduct() {
		return "Delete Product";
	}

	@GetMapping
	public String getProducts() {
		return "Get all Products";
	}

	@GetMapping("{productId}")
	public String getProduct(@PathVariable("productId") int productId) {
		return "Get Product for " + productId;
	}
}
