package com.springrest.inventoryManagement.springrest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.inventoryManagement.springrest.entities.Godowns;
import com.springrest.inventoryManagement.springrest.repository.GodownsRepository;




@Service
public class GodownServiceImpl implements GodownService {
    @Autowired
    private GodownsRepository godownsRepository;

    @Override
    public Godowns getGodownsById(int godown_Id) {
        return godownsRepository.findById(godown_Id).orElse(null);
    }

    @Override
	public List<Godowns> findAll() {
		// TODO Auto-generated method stub
		return godownsRepository.findAll();
	}

    @Override
    public void addGodowns(Godowns godownss) {
    	godownsRepository.save(godownss);
    }

    @Override
    public void updateGodowns(Godowns godownss) {
    	godownsRepository.save(godownss);
    }

    @Override
    public void deleteGodowns(int godown_Id) {
    	godownsRepository.deleteById(godown_Id);
    }
}