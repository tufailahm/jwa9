package com.training.jwa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.training.jwa.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

	public List<Product> findByProductName(String productName);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Product> findByPrice(int price);
	public List<Product> findByPriceBetween(int minprice,int maximum);
	public List<Product> findByQuantityOnHandBetween(int minquantity,int maximumquantity);
	public List<Product> findByProductNameAndPrice(String productName,int price);


}
