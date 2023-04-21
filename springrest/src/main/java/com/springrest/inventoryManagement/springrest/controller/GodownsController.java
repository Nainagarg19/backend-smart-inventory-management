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

import com.springrest.inventoryManagement.springrest.entities.Godowns;
import com.springrest.inventoryManagement.springrest.repository.GodownsRepository;


@RestController

public class GodownsController {
	@Autowired
	GodownsRepository GodownsRepository;
	
	List<Godowns> godownss = new ArrayList<>();

	
	
	@GetMapping(path="/godownss")
	public List<Godowns> getGodownss() {
		//return godownss;
		
		return GodownsRepository.findAll();
	}
	
	
	@PostMapping(path="/godownss")
	public void addGodowns(@RequestBody Godowns g) {
		//Godownss.add(e);
		GodownsRepository.save(g);
	}
	@DeleteMapping(path="/godownss/{id}")
	public void deleteGodowns(@PathVariable int id) {
		System.out.println("Id:"+id);
		GodownsRepository.deleteById(id);

	}
	@PatchMapping(path="/godownss")
	public void updateGodowns(@RequestBody Godowns godowns) {
		Optional<Godowns> godownsFound=GodownsRepository.findById(godowns.getGodown_Id());
		if(godownsFound.isPresent()) {
			Godowns g = godownsFound.get();
			g.setLocation(godowns.getLocation());
			g.setCapacity(godowns.getCapacity());
			g.setManager(godowns.getManager());
			g.setStart_date(godowns.getStart_date());
			GodownsRepository.save(g);
		}
	
	}	
}