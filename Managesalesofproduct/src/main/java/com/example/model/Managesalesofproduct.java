package com.example.model;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Managesalesofproduct {
	@Id
	private int product_id;
	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	private int numberofitems;
	private String productname;
	private int productprice;
	
	
	public Managesalesofproduct(){}


	public Managesalesofproduct(int product_id, int numberofitems, String productname, int productprice) {
		super();
		this.product_id = product_id;
		this.numberofitems = numberofitems;
		this.productname = productname;
		this.productprice = productprice;
		
	}


	public int getNumberofitems() {
		return numberofitems;
	}


	public void setNumberofitems(int numberofitems) {
		this.numberofitems = numberofitems;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public int getProductprice() {
		return productprice;
	}


	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	
	
	
}
