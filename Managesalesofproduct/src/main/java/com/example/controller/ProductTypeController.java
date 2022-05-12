package com.example.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.ResourceNotFoundException;
import com.example.model.ProductType;
import com.example.service.ProductTypeService;

@RestController
@RequestMapping("/Store")
public class ProductTypeController {

	@Autowired
	private ProductTypeService productTypeService;

	@GetMapping("/ProductType")
	public ResponseEntity<?> getAllProduct() {
		if (productTypeService.getAllProduct().isEmpty())
			return new ResponseEntity<>("No records of product found!", HttpStatus.OK);
		else
			return new ResponseEntity<>(productTypeService.getAllProduct(), HttpStatus.OK);
	}

	@GetMapping("/ProductType/{No}")
	public ResponseEntity<?> getProductById(@PathVariable(value = "No") Integer No) {
		try {
			return new ResponseEntity<>(productTypeService.getProductById(No), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("productType by " + No + " No not found!").getMessage(), HttpStatus.OK);
		}
	}

	@PostMapping("/ProductType/add")
	public ResponseEntity<?> addNewProduct(@RequestBody ProductType product) {
		try {
			if (productTypeService.existsById(product.getProductNo()))
				return new ResponseEntity<>(
						"ProductType by " + product.getProductNo() + " No exists already! Please provide an unique ID.",
						HttpStatus.OK);
			else
				return new ResponseEntity<>(productTypeService.addNewProduct(product), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Please check the input and format.", HttpStatus.OK);
		}
	}

	@PutMapping("/ProductType/update/{No}")
	public ResponseEntity<?> updateProduct(@PathVariable(value = "No") Integer No,
			@RequestBody ProductType product) {
		try {
			return new ResponseEntity<>(productTypeService.updateProduct(No, product), HttpStatus.OK);
		} catch (NoSuchElementException noSuchElement) {
			return new ResponseEntity<>("Producttype by " + No + " No not found!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.OK);
		}
	}

	@DeleteMapping("/ProductType/delete/{No}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "No") Integer No) {
		try {
			productTypeService.deleteProduct(No);
			return new ResponseEntity<>("Successfully deleted product with No as " + No, HttpStatus.OK);
		} catch (EmptyResultDataAccessException emptyResultData) {
			return new ResponseEntity<>("ProductType by " + No + " No not found!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.OK);
		}
	}
}
