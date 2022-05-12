package com.example.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repositories.BillRepository;
import com.example.model.Bill;
@Service
public class BillServiceImp implements BillService {
	
	private BillRepository billRepository;
	@Autowired
	public BillServiceImp(BillRepository billRepository) {
		super();
		this.billRepository = billRepository;
	}

	@Override
	public List<Bill> getAllBill() {
		return billRepository.findAll();
	}

	@Override
	public Bill addNewBill(Bill bill) {
		return this.billRepository.save(bill);
	}

	public Bill updateBill(Integer No, Bill bill) {
		bill = getBillById(No);
		bill.setProductName(bill.getProductName());
		bill.setProductType(bill.getProductType());
		bill.setColour(bill.getColour());
		bill.setDimension(bill.getDimension());
		Bill bill1 = billRepository.save(bill);
		return bill1;
	}

	@Override
	public Bill getBillById(Integer No) {
		return billRepository.findById(No).get();
	}

	@Override
	public boolean existsById(Integer No) {
		return billRepository.existsById(No);
	}

	public void deleteBill(Integer No) {
		billRepository.deleteById(No);
		
	}

}

