package com.springrest.inventoryManagement.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.inventoryManagement.springrest.entities.Godowns;
import com.springrest.inventoryManagement.springrest.repository.GodownsRepository;


@Service
public class GodownService {

	@Autowired
	private GodownsRepository godownsRepository;
	
	public List<Godowns> getAllGodowns() {
		return godownsRepository.findAll();
	}
	
	public Optional<Godowns> getGodownsById(int godown_Id) {
		return godownsRepository.findById(godown_Id);
	}
	
	public void addGodowns(Godowns godowns) {
		godownsRepository.save(godowns);
	}
	
	public void updateGodowns(int godown_Id, Godowns godowns) {
		Optional<Godowns> optionalGodowns = godownsRepository.findById(godown_Id);
		if (optionalGodowns.isPresent()) {
			godowns.setGodown_Id(godown_Id);
			godownsRepository.save(godowns);
		}
	}
	
	public void deleteGodowns(int godown_Id) {
		godownsRepository.deleteById(godown_Id);
	}
}
