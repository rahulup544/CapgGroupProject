package com.example.service;

import java.util.List;

import com.example.model.Bill;
import com.example.model.ProductType;


public interface ProductTypeService {
List<ProductType> getAllProduct();
	
	ProductType addNewProduct(ProductType product);
	
	ProductType updateProduct(Integer No, ProductType product);
	ProductType getProductById(Integer No);
	boolean existsById(Integer No);
	
	Bill deleteProduct(Integer No);

}
