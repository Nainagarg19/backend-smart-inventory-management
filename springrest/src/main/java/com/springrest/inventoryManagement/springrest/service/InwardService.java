package com.springrest.inventoryManagement.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.inventoryManagement.springrest.entities.Inwards;
import com.springrest.inventoryManagement.springrest.repository.InwardsRepository;


@Service
public class InwardService {

	@Autowired
	private InwardsRepository inwardsRepository;
	
	public List<Inwards> getAllInwards() {
		return inwardsRepository.findAll();
	}
	
	public Optional<Inwards> getInwardsById(int Inwards_Id) {
		return inwardsRepository.findById(Inwards_Id);
	}
	
	public void addInwards(Inwards inwards) {
		inwardsRepository.save(inwards);
	}
	
	public void updateInwards(int inwards_Id, Inwards inwards) {
		Optional<Inwards> optionalInwards = inwardsRepository.findById(inwards_Id);
		if (optionalInwards.isPresent()) {
			inwards.setInwards_Id(inwards_Id);
			inwardsRepository.save(inwards);
		}
	}
	
	public void deleteInwards(int inwards_Id) {
		inwardsRepository.deleteById(inwards_Id);
	}
}
