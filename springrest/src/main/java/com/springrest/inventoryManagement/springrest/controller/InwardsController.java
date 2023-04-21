package com.springrest.inventoryManagement.springrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.inventoryManagement.springrest.entities.Inwards;
import com.springrest.inventoryManagement.springrest.repository.InwardsRepository;


@RestController

public class InwardsController {
	@Autowired
	InwardsRepository inwardsRepository;
	
	List<Inwards> inwardss = new ArrayList<>();

	
	
	@GetMapping(path="/inwardss")
	public List<Inwards> getInwardss() {
		//return inwardss;
		
		return inwardsRepository.findAll();
	}
	
	
	
	@PostMapping(path="/inwardss")
	public void addInwards(@RequestBody Inwards i) {
		//Outwardss.add(e);
		inwardsRepository.save(i);
	}
	@DeleteMapping(path="/inwardss/{id}")
	public void deleteInwards(@PathVariable int id) {
		System.out.println("Id:"+id);
		inwardsRepository.deleteById(id);

	}
	@PatchMapping(path="/inwardss")
	public void updateInwards(@RequestBody Inwards inwards) {
		Optional<Inwards> inwardsFound=inwardsRepository.findById(inwards.getInwards_Id());
		if(inwardsFound.isPresent()) {
			Inwards i = inwardsFound.get();
			i.setDate_of_supply(inwards.getDate_of_supply());
			i.setChecked_by(inwards.getChecked_by());
			i.setGodown_id(inwards.getGodown_id());
			i.setItem_id(inwards.getItem_id());
			i.setGodown_id(inwards.getGodown_id());
			i.setInvoice_no(inwards.getInvoice_no());
			i.setRecieved_by(inwards.getRecieved_by());
			i.setItem_name(inwards.getItem_name());
			i.setQuantity(inwards.getQuantity());
			i.setReciept_no(inwards.getReciept_no());
			i.setSupplier_name(inwards.getSupplier_name());
			
			inwardsRepository.save(i);
		}
	
	}	
}