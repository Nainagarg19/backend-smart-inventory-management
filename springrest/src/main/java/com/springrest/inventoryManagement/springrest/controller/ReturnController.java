package com.springrest.inventoryManagement.springrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.inventoryManagement.springrest.entities.Return;
import com.springrest.inventoryManagement.springrest.repository.ReturnRepository;


@RestController

public class ReturnController {
	@Autowired
	ReturnRepository returnRepository;
	
	List<Return> returns = new ArrayList<>();

	
	
	@GetMapping(path="/returns")
	public List<Return> getReturns() {
		//return Returns;
		
		return returnRepository.findAll();
	}
	
	@PostMapping(path="/returns")
	public void addReturn(@RequestBody Return r) {
		//Returns.add(e);
		returnRepository.save(r);
	}
	@DeleteMapping(path="/returns/{id}")
	public void deleteReturn(@PathVariable int id) {
		System.out.println("Id:"+id);
		returnRepository.deleteById(id);
	}
	
	
	
	@PatchMapping(path="/returns")
	public void updateReturn(@RequestBody Return retur) {
		Optional<Return> returnFound=returnRepository.findById(retur.getReturnId());
		if(returnFound.isPresent()) {
			Return r = returnFound.get();
			r.setBill_value(retur.getBill_value());
			r.setCapacity(retur.getCapacity());
			r.setChecked_by(retur.getChecked_by());
			r.setDate_of_del(retur.getDate_of_del());
			r.setDate_of_return(retur.isDate_of_return());
			r.setGodown_id(retur.getGodown_id());
			r.setInvoice_no(retur.getInvoice_no());
			r.setItem_name(retur.getItem_name());
			r.setManager(retur.getManager());
			r.setQuantity(retur.getQuantity());
			r.setReciept_no(retur.getReciept_no());
			r.setReturn_by(retur.getReturn_by());
			r.setReturn_date(retur.getReturn_date());
			returnRepository.save(r);
		}
	
	
	}
}
