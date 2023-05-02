package com.springrest.inventoryManagement.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.inventoryManagement.springrest.entities.Return;
import com.springrest.inventoryManagement.springrest.repository.ReturnRepository;


@Service
public class ReturnService {

	@Autowired
	private ReturnRepository returnRepository;
	
	public List<Return> getAllReturns() {
		return returnRepository.findAll();
	}
	
	public Optional<Return> getReturnById(int returnId) {
		return returnRepository.findById(returnId);
	}
	
	public void addReturns(Return returns) {
		returnRepository.save(returns);
	}
	
	public void updateReturns(int returnId, Return returns) {
		Optional<Return> optionalReturn = returnRepository.findById(returnId);
		if (optionalReturn.isPresent()) {
			returns.setReturnId(returnId);
			returnRepository.save(returns);
		}
	}
	
	public void deleteReturns(int returnId) {
		returnRepository.deleteById(returnId);
	}
}
