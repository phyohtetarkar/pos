package com.jsoft.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.pos.entity.Supplier;
import com.jsoft.pos.repo.PersonRepo;
import com.jsoft.pos.repo.SupplierRepo;

@Service
public class SupplierService extends PersonService<Supplier, Integer> {

	@Autowired
    private SupplierRepo repo;

	@Override
	protected PersonRepo<Supplier, Integer> getRepo() {
		return repo;
	}

}