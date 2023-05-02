package com.springrest.inventoryManagement.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.inventoryManagement.springrest.entities.Outwards;
import com.springrest.inventoryManagement.springrest.repository.OutwardsRepository;


@Service
public class OutwardService {

	@Autowired
	private OutwardsRepository outwardsRepository;
	
	public List<Outwards> getAllOutwards() {
		return outwardsRepository.findAll();
	}
	
	public Optional<Outwards> getOutwardsById(int outward_Id) {
		return outwardsRepository.findById(outward_Id);
	}
	
	public void addOutwards(Outwards Outwards) {
		outwardsRepository.save(Outwards);
	}
	
	public void updateOutwards(int outward_Id, Outwards outwards) {
		Optional<Outwards> optionalOutwards = outwardsRepository.findById(outward_Id);
		if (optionalOutwards.isPresent()) {
			outwards.setOutward_Id(outward_Id);
			outwardsRepository.save(outwards);
		}
	}
	
	public void deleteOutwards(int outward_Id) {
		outwardsRepository.deleteById(outward_Id);
	}
}
