package com.training.jwa.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.jwa.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
