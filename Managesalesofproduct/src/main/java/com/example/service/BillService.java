package com.example.service;
import java.util.List;

import com.example.model.Bill;


public interface BillService {
List<Bill> getAllBill();
	
	Bill addNewBill(Bill bill);
	
	static Bill updateBill(Integer No, Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}
	Bill getBillById(Integer No);
	boolean existsById(Integer No);
	
	static void deleteBill(Integer No) {
		// TODO Auto-generated method stub
		
	}

}
