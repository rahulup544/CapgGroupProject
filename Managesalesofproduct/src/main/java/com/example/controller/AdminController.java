package com.example.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Bill;
import com.example.model.ProductType;
import com.example.service.BillService;
import com.example.service.ProductTypeService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	BillService obj;
	@Autowired 
	 ProductTypeService service;
	@GetMapping("/fetchproductbilldetails")
	public List<Bill> fetchbill(){
		List<Bill> list=obj.getAllBill();
		return list;
	}
@PostMapping("/addproductbill")
public void addproductbill(@RequestBody Bill b) {
	obj.addNewBill(b);
	System.out.println("Bill added sucessfully");
}
@PutMapping("/updateproduct/{id}")
public ResponseEntity<ProductType> updateproducttype(@PathVariable(value="id")Integer id,@RequestBody ProductType pt){
	ProductType p=service.updateProduct(id, pt);
	return new ResponseEntity<ProductType>(p,HttpStatus.OK);
}
@DeleteMapping("/deleteproductbill/{id}")
public  ResponseEntity<Bill> deletebill(@PathVariable(value="id")Integer id){
	Bill b=service.deleteProduct(id);
	return new  ResponseEntity<Bill>(b,HttpStatus.OK);
}
}