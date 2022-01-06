package com.training.jwa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.jwa.model.Product;
import com.training.jwa.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public String saveProduct(Product product) {
		if (product.getPrice() < 0 || product.getQuantityOnHand() < 0)
			// check whether the price and qoh must not be negative
			return "Product price or qoh cannot be negative";
		else {
			productRepository.save(product);
			return "Product saved successfully";
		}
	}

	@Override
	public String updateProduct(Product product) {
		if (product.getPrice() < 0 || product.getQuantityOnHand() < 0)
			// check whether the price and qoh must not be negative
			return "Product price or qoh cannot be negative";
		else {
			productRepository.save(product);
			return "Product updated successfully";
		}
	}

	@Override
	public String deleteProduct(int productId) {
		productRepository.deleteById(productId);
		return "Product with product id : " + productId + " deleted successfully !!";
	}

	@Override
	public Product getProduct(int productId) {
		Optional<Product> product = productRepository.findById(productId);
		return product.get();
	}

	@Override
	public List<Product> getProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public boolean isProductExists(int productId) {
		Optional<Product> product = productRepository.findById(productId);
		return product.isPresent();
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		return productRepository.findByProductName(productName);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<Product> getProductsByPrice(int price) {
		return productRepository.findByPrice(price);
	}

	@Override
	public List<Product> getProductsByPriceRange(int minimunPrice, int maximumPrice) {
		return productRepository.findByPriceBetween(minimunPrice, maximumPrice);
	}

	@Override
	public List<Product> getProductsByQuanityRange(int minimunQuantity, int maximumQuantity) {
		return productRepository.findByQuantityOnHandBetween(minimunQuantity, maximumQuantity);
	}

	@Override
	public List<Product> getProductsByNameAndPrice(String productName, int price) {
		return productRepository.findByProductNameAndPrice(productName, price);
	}

}
