package com.training.jwa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
		private int productId;
		private String productName;
		private int quantityOnHand;
		private int price;
		
}
