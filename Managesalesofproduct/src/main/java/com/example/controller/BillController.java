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
import com.example.model.Bill;
import com.example.service.BillService;

@RestController
@RequestMapping("/Billingsystem")
public class BillController {

	@Autowired
	private BillService billService;

	@GetMapping("/Bill")
	public ResponseEntity<?> getAllBill() {
		if (billService.getAllBill().isEmpty())
			return new ResponseEntity<>("No records of bill found!", HttpStatus.OK);
		else
			return new ResponseEntity<>(billService.getAllBill(), HttpStatus.OK);
	}

	@GetMapping("/Bill/{No}")
	public ResponseEntity<?> getBillById(@PathVariable(value = "No") Integer No) {
		try {
			return new ResponseEntity<>(billService.getBillById(No), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("bill by " + No + " No not found!").getMessage(), HttpStatus.OK);
		}
	}

	@PostMapping("/Bill/add")
	public ResponseEntity<?> addNewBill(@RequestBody Bill bill) {
		try {
			if (billService.existsById(bill.getBillNo()))
				return new ResponseEntity<>(
						"Bill by " + bill.getBillNo() + " No exists already! Please provide an unique ID.",
						HttpStatus.OK);
			else
				return new ResponseEntity<>(billService.addNewBill(bill), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Please check the input and format.", HttpStatus.OK);
		}
	}

	@PutMapping("/Bill/update/{No}")
	public ResponseEntity<?> updateBill(@PathVariable(value = "No") Integer No,
			 @RequestBody Bill bill) {
		try {
			return new ResponseEntity<>(BillService.updateBill(No, bill), HttpStatus.OK);
		} catch (NoSuchElementException noSuchElement) {
			return new ResponseEntity<>("Bill by " + No + " No not found!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.OK);
		}
	}

	@DeleteMapping("/Bill/delete/{No}")
	public ResponseEntity<?> deleteBill(@PathVariable(value = "No") Integer No) {
		try {
			BillService.deleteBill(No);
			return new ResponseEntity<>("Successfully deleted bill with No as " + No, HttpStatus.OK);
		} catch (EmptyResultDataAccessException emptyResultData) {
			return new ResponseEntity<>("bill by " + No + " No not found!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.OK);
		}
	}
}