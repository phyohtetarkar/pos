package com.jsoft.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.pos.entity.Customer;
import com.jsoft.pos.repo.CustomerRepo;
import com.jsoft.pos.repo.PersonRepo;

@Service
public class CustomerService extends PersonService<Customer> {

	@Autowired
    private CustomerRepo repo;

	@Override
	protected PersonRepo<Customer> getRepo() {
		return repo;
	}

}