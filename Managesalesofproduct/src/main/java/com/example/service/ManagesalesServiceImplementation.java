package com.example.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Managesalesofproduct;
import com.example.repositories.Managesalesofproductrepositories;

@Service
public class ManagesalesServiceImplementation implements ManagesalesService{
	@Autowired
	Managesalesofproductrepositories rep;
	
	@Override
	public List<Managesalesofproduct> getManagesalesofproductList() {
		// TODO Auto-generated method stub
		List<Managesalesofproduct> list=rep.findAll();
		return list;
	}

	@Override
	public Managesalesofproduct getByProduct_id(int product_id) {
Managesalesofproduct m=rep.getById(product_id);
		return m;
	}

	@Override
	public void saveManagesalesofproduct(Managesalesofproduct m) {
		// TODO Auto-generated method stub
		rep.save(m);
	}

	@Override
	public Managesalesofproduct updateManagesalesofproduct(Managesalesofproduct m, int product_id) {
		Managesalesofproduct it=rep.getById(product_id);
		it.setProductname(m.getProductname());
		it.setNumberofitems(m.getNumberofitems());
		it.setProductprice(m.getProductprice());
		rep.save(it);
		return it;
		
	}

	@Override
	public Managesalesofproduct deleteManagesalesofproductById(int product_id) {
		// TODO Auto-generated method stub
		Managesalesofproduct m=rep.getById(product_id);
		rep.deleteById(product_id);;
		return m;
	}

}
