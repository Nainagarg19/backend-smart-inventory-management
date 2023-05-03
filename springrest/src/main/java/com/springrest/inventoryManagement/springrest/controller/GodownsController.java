package com.springrest.inventoryManagement.springrest.controller;


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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.inventoryManagement.springrest.entities.Godowns;
import com.springrest.inventoryManagement.springrest.service.GodownService;


@RestController
@RequestMapping("/api/godowns")
public class GodownsController {
    @Autowired
    private GodownService godownsService;

    @GetMapping
	public List<Godowns> getAllGodowns() {
		return godownsService.getAllGodowns();
	}
	
	@GetMapping("/{godown_Id}")
	public ResponseEntity<Godowns> getGodownsById(@PathVariable int godown_Id) {
		Optional<Godowns> optionalGodowns = godownsService.getGodownsById(godown_Id);
		if (optionalGodowns.isPresent()) {
			return new ResponseEntity<>(optionalGodowns.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public void addGodowns(@RequestBody Godowns godowns) {
		godownsService.addGodowns(godowns);
	}
	
	//@PutMapping("/{godown_Id}")
	//public void updateGodowns1(@PathVariable int godown_Id, @RequestBody Godowns godowns) {
	//	godownsService.updateGodowns(godown_Id, godowns);
	//}
	
	@PatchMapping("/{godown_Id}")
	public String updateGodowns(@PathVariable int godown_Id, @RequestBody Godowns godowns) {
		godownsService.updateGodowns(godown_Id, godowns);
		return "Successfull";
	}
	
	@DeleteMapping("/{godown_Id}")
	public String deleteGodowns(@PathVariable int godown_Id) {
		godownsService.deleteGodowns(godown_Id);
		return "Successfull";
	}
}
