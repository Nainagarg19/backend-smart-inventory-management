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

import com.springrest.inventoryManagement.springrest.entities.Outwards;
import com.springrest.inventoryManagement.springrest.repository.OutwardsRepository;


@RestController

public class OutwardsController {
	@Autowired
	OutwardsRepository outwardsRepository;
	
	List<Outwards> outwardss = new ArrayList<>();

	
	
	@GetMapping(path="/outwardss")
	public List<Outwards> getOutwardss() {
		//return outwardss;
		
		return outwardsRepository.findAll();
	}
	
	
	
	@PostMapping(path="/outwardss")
	public void addOutwards(@RequestBody Outwards o) {
		//Outwardss.add(e);
		outwardsRepository.save(o);
	}
	@DeleteMapping(path="/outwardss/{id}")
	public void deleteOutwards(@PathVariable int id) {
		System.out.println("Id:"+id);
		outwardsRepository.deleteById(id);

	}
	@PatchMapping(path="/outwardss")
	public void updateOutwards(@RequestBody Outwards outwards) {
		Optional<Outwards> outwardsFound=outwardsRepository.findById(outwards.getOutward_Id());
		if(outwardsFound.isPresent()) {
			Outwards o = outwardsFound.get();
			o.setBill_value(outwards.getBill_value());
			o.setChecked_by(outwards.getChecked_by());
			o.setDate_of_del(outwards.getDate_of_del());
			o.setDate_of_supply(outwards.getDate_of_supply());
			o.setDelivered_to(outwards.getDelivered_to());
			o.setGodown_id(outwards.getGodown_id());
			o.setInvoice_no(outwards.getInvoice_no());
			o.setPurpose(outwards.getPurpose());
			o.setItem_name(outwards.getItem_name());
			o.setQuantity(outwards.getQuantity());
			o.setReciept_no(outwards.getReciept_no());
		
			
			outwardsRepository.save(o);
		}
	
	}	
}