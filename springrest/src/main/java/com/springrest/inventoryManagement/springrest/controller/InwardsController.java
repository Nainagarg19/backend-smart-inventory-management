package com.springrest.inventoryManagement.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.springrest.inventoryManagement.springrest.entities.Inwards;
import com.springrest.inventoryManagement.springrest.service.InwardService;


@RestController
@RequestMapping("/api/inwards")
public class InwardsController {
    @Autowired
    private InwardService inwardservice;
    @GetMapping
	public List<Inwards> getAllInwards() {
		return inwardservice.getAllInwards();
	}
	
	@GetMapping("/{inwards_Id}")
	public ResponseEntity<Inwards> getInwardsById(@PathVariable int inwards_Id) {
		Optional<Inwards> optionalInwards = inwardservice.getInwardsById(inwards_Id);
		if (optionalInwards.isPresent()) {
			return new ResponseEntity<>(optionalInwards.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public void addInwards(@RequestBody Inwards inwards) {
		inwardservice.addInwards(inwards);
	}
	
	@PutMapping("/{inwards_Id}")
	public void updateInwards(@PathVariable int inwards_Id, @RequestBody Inwards inwards) {
		inwardservice.updateInwards(inwards_Id, inwards);
	}
	
	@DeleteMapping("/{inwards_Id}")
	public void deleteInwards(@PathVariable int inwards_Id) {
		inwardservice.deleteInwards(inwards_Id);
	}
}