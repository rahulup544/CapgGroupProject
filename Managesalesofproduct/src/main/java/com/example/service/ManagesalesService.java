package com.example.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.model.Managesalesofproduct;
@Service
public interface ManagesalesService  {
List<Managesalesofproduct> getManagesalesofproductList();
Managesalesofproduct getByProduct_id(int product_id);
void saveManagesalesofproduct(Managesalesofproduct m);
Managesalesofproduct updateManagesalesofproduct( Managesalesofproduct m,int product_id);
Managesalesofproduct deleteManagesalesofproductById(int product_id);

}
 
