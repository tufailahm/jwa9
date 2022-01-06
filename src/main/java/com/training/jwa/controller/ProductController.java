package com.training.jwa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.jwa.model.Product;
import com.training.jwa.service.ProductService;

@RestController
@RequestMapping("product") // localhost:9090/product
public class ProductController {

	@Autowired
	ProductService productService;

	// ResponseEntity in spring entity
	@PostMapping
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		ResponseEntity<String> responseEntity = null;
		String result = null;
		if (productService.isProductExists(product.getProductId())) {
			// failed
			responseEntity = new ResponseEntity<String>("Product already exists", HttpStatus.CONFLICT); // 409
		} else {
			result = productService.saveProduct(product);
			if (result.equals("Product saved successfully")) {
				responseEntity = new ResponseEntity<String>(result, HttpStatus.CREATED); // 201
			} else {
				responseEntity = new ResponseEntity<String>(result, HttpStatus.NOT_ACCEPTABLE); // 406
			}
		}
		// send appropriate status codes
		return responseEntity;
	}

	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		ResponseEntity<String> responseEntity = null;
		String result = null;
		if (!productService.isProductExists(product.getProductId())) {
			// failed
			responseEntity = new ResponseEntity<String>("Product does not exists", HttpStatus.NO_CONTENT); // 204
		} else {
			result = productService.updateProduct(product);
			if (result.equals("Product updated successfully")) {
				responseEntity = new ResponseEntity<String>(result, HttpStatus.OK); // 201
			} else {
				responseEntity = new ResponseEntity<String>(result, HttpStatus.NOT_ACCEPTABLE); // 406
			}
		}
		// send appropriate status codes
		return responseEntity;
	}

	@DeleteMapping("{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {
		ResponseEntity<String> responseEntity = null;
		String result = null;
		if (!productService.isProductExists(productId)) {
			// failed
			responseEntity = new ResponseEntity<String>("Product does not exists", HttpStatus.NOT_FOUND); // 404
		} else {
			result = productService.deleteProduct(productId);
			if (result.equals("Product with product id : " + productId + " deleted successfully !!")) {
				responseEntity = new ResponseEntity<String>(result, HttpStatus.OK); // 201
			} else {
				responseEntity = new ResponseEntity<String>(result, HttpStatus.NOT_ACCEPTABLE); // 406
			}
		}
		// send appropriate status codes
		return responseEntity;
	}
	@GetMapping
	public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false) String productName) {
		ResponseEntity<List<Product>> responseEntity = null;
		List<Product> products = new ArrayList<Product>();
		if (productName == null) {
			products = productService.getProducts();
		} else {
			products = productService.getProductsByName(productName);
		}
		if (products.size() == 0) {
			responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.NO_CONTENT); // 201
		} else {
			responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.OK); // 201
		}

		return responseEntity;
	}

	// Hands on --
	@GetMapping("{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) {
		ResponseEntity<Product> responseEntity = null;
		Product product = null;

		if (!productService.isProductExists(productId))
			responseEntity = new ResponseEntity<Product>(product, HttpStatus.NO_CONTENT); // 204
		else {
			product = productService.getProduct(productId);
			responseEntity = new ResponseEntity<Product>(product, HttpStatus.OK); // 200
		}
		return responseEntity;
	}

}
