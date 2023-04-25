package com.springrest.inventoryManagement.springrest.controller;


import java.util.List;

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
import com.springrest.inventoryManagement.springrest.entities.Godowns;
import com.springrest.inventoryManagement.springrest.service.GodownService;


@RestController
@RequestMapping("/api/godowns")
public class GodownsController {
    @Autowired
    private GodownService godownsService;

    @GetMapping("/{godown_Id}")
    public ResponseEntity<Godowns> getGodownsById(@PathVariable int godown_Id) {
    	Godowns godowns = godownsService.getGodownsById(godown_Id);
        if (godowns == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(godowns, HttpStatus.OK);
        }
    }
    
    @GetMapping(path="")
	public List<Godowns> getAllGodowns() {
		//return employees;
		
		return godownsService.findAll();
	}

    @PostMapping("")
    public ResponseEntity<Godowns> addGodowns(@RequestBody Godowns godowns) {
    	godownsService.addGodowns(godowns);
        return new ResponseEntity<>(godowns, HttpStatus.CREATED);
    }

    @PutMapping("/{godown_Id}")
    public ResponseEntity<Godowns> updateGodowns(@PathVariable int godown_Id, @RequestBody Godowns godowns) {
        if (godownsService.getGodownsById(godown_Id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        	godowns.setGodown_Id(godown_Id);
            godownsService.updateGodowns(godowns);
            return new ResponseEntity<>(godowns, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{godown_Id}")
    public ResponseEntity<Godowns> deleteGodowns(@PathVariable int godown_Id) {
    	Godowns godowns = godownsService.getGodownsById(godown_Id);
        if (godowns == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        	godownsService.deleteGodowns(godown_Id);
            return new ResponseEntity<>(godowns, HttpStatus.OK);
        }
    }
}
