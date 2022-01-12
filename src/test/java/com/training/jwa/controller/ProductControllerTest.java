package com.training.jwa.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.training.jwa.model.Product;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class ProductControllerTest extends AbstractTest {

	String uri = "/product";
	int productId = 999;
	
	@BeforeEach
	protected void setUp() {
		super.setUp();
	}

	@Test
	@DisplayName("Testing save product")
	@Order(1)
	void testSaveProduct() throws Exception {
		Product product = new Product(productId, "DummyProduct", 100, 200);
		System.out.println(product);
		//convert the product object into json format
		String productJSON = super.mapToJson(product);
		System.out.println(productJSON);
		MvcResult mvcResult  = mockMvc.perform(
				MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(productJSON)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		
		assertEquals(201, status);
		assertEquals(content, "Product saved successfully");
		
	}

	
	//Testing update
	@Test
	@DisplayName("Testing update product")
	@Order(2)
	void testUpdateProduct() throws Exception {
		Product product = new Product(productId, "NewDummyProduct", 200, 300);
		System.out.println(product);
		//convert the product object into json format
		String productJSON = super.mapToJson(product);
		System.out.println(productJSON);
		MvcResult mvcResult  = mockMvc.perform(
				MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(productJSON)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		
		assertEquals(200, status);
		assertEquals(content, "Product updated successfully");
	}

	@Test
	@DisplayName("Testing delete product")
	@Order(5)
	void testDeleteProduct() throws Exception {
		MvcResult mvcResult  = mockMvc.perform(
				MockMvcRequestBuilders.delete(uri+"/"+productId)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(200, status);
		assertEquals("Product with product id : " + productId + " deleted successfully !!", content);
	}

	

	@Test
	@DisplayName("Testing get single product")
	@Order(4)
	void testGetProduct() throws Exception {
		Product expectedProduct = new Product(productId, "NewDummyProduct", 200, 300);

		MvcResult mvcResult  = mockMvc.perform(
				MockMvcRequestBuilders.get(uri+"/"+productId)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		Product actualProduct = super.mapFromJson(content, Product.class);
		assertEquals(200, status);
		assertEquals(expectedProduct, actualProduct);
	}
	
	
	@Test
	@DisplayName("Testing get all products")
	@Order(3)
	void testGetProducts() throws Exception {
		MvcResult mvcResult  = mockMvc.perform(
				MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		Product []products = super.mapFromJson(content, Product[].class);
		assertEquals(200, status);
		assertTrue(products.length > 0);
	}
	
	
	
	
	
	
	
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}
