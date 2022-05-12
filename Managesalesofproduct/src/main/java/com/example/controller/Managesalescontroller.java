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

import com.example.model.Managesalesofproduct;
import com.example.service.ManagesalesService;
@RestController
@RequestMapping("/sales")
public class Managesalescontroller {
@Autowired
ManagesalesService service;

@RequestMapping("/managesalesclass")
public String test()
{
	return "Managesales Controller class";
}
@RequestMapping("/fetchmanagesalesdetails")
List<Managesalesofproduct> getList()
{
	List<Managesalesofproduct> list=service.getManagesalesofproductList();
	System.out.println("The product details are: "+"\n");
	for(Managesalesofproduct c:list)
	{
		System.out.println(c+"\n");
	}
	return list;
}
@GetMapping("managesalesofproduct/{product_id}")
public String read(@PathVariable("product_id") int product_id){
	Managesalesofproduct c=service.getByProduct_id(product_id);
	String st=c.toString();
	return st;
}
@RequestMapping("/getmanagesales/{product_id}")
public ResponseEntity<Managesalesofproduct> findOne(@PathVariable(value="product_id") Integer product_id){
	Managesalesofproduct pt=service.getByProduct_id(product_id);
	try {
	if(pt!=null)
	{
		return new ResponseEntity<>(pt,HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(pt,HttpStatus.NOT_FOUND);
	}}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PostMapping("/save")
public ResponseEntity<Managesalesofproduct> saveManagesales(@RequestBody Managesalesofproduct p)
{
	try {
	 Managesalesofproduct pt=p;
	service.saveManagesalesofproduct(pt);
	return new ResponseEntity<Managesalesofproduct>(pt,HttpStatus.OK);}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PutMapping("/update")
public ResponseEntity<Managesalesofproduct> updateManagesales(@RequestBody Managesalesofproduct p)
{
	try {
	service.updateManagesalesofproduct(p, p.getProduct_id());
	return new ResponseEntity<Managesalesofproduct>(p,HttpStatus.OK); }
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<Managesalesofproduct> deleteManagesales(@PathVariable(value="product_id") Integer product_id){
	try {
		Managesalesofproduct c=service.deleteManagesalesofproductById(product_id);
	return new ResponseEntity<Managesalesofproduct>(c,HttpStatus.OK);}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}}