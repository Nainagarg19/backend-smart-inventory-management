package com.springrest.inventoryManagement.springrest.service;

import java.util.List;

import com.springrest.inventoryManagement.springrest.entities.Godowns;




public interface GodownService {
    public Godowns getGodownsById(int godown_Id);

	public List<Godowns> findAll();

    public void addGodowns(Godowns godownss);

    public void updateGodowns(Godowns godownss);

    public void deleteGodowns(int godown_Id);
}