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

import com.springrest.inventoryManagement.springrest.entities.Return;
import com.springrest.inventoryManagement.springrest.service.ReturnService;


@RestController
@RequestMapping("/api/returns")
public class ReturnController {
    @Autowired
    private ReturnService returnService;
    @GetMapping
	public List<Return> getAllReturns() {
		return returnService.getAllReturns();
	}
	
	@GetMapping("/{returnId}")
	public ResponseEntity<Return> getReturnsById(@PathVariable int returnId) {
		Optional<Return> optionalReturns = returnService.getReturnById(returnId);
		if (optionalReturns.isPresent()) {
			return new ResponseEntity<>(optionalReturns.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public void addReturns(@RequestBody Return returns) {
		returnService.addReturns(returns);
	}
	
	@PutMapping("/{returnId}")
	public void updateReturns(@PathVariable int returnId, @RequestBody Return returns) {
		returnService.updateReturns(returnId, returns);
	}
	
	@DeleteMapping("/{returnId}")
	public void deleteReturns(@PathVariable int returnId) {
		returnService.deleteReturns(returnId);
	}
}