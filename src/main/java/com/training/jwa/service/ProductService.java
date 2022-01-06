package com.training.jwa.service;

import java.util.List;

import com.training.jwa.model.Product;

public interface ProductService {
		public String saveProduct(Product product);
		public String updateProduct(Product product);
		public String deleteProduct(int productId);
		public Product getProduct(int productId);
		public List<Product> getProducts();
		public boolean isProductExists(int productId);

		
		//
		public List<Product> getProductsByName(String productName);
		public List<Product> getProductsByPrice(int price);
		public List<Product> getProductsByPriceRange(int minimunPrice,int maximumPrice);
		public List<Product> getProductsByQuanityRange(int minimunQuantity,int maximumQuantity);
		
		public List<Product> getProductsByNameAndPrice(String productName,int price);

}
