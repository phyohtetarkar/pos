package com.jsoft.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.pos.entity.Employee;
import com.jsoft.pos.repo.EmployeeRepo;
import com.jsoft.pos.repo.PersonRepo;

@Service
public class EmployeeService extends PersonService<Employee, Integer> {

	@Autowired
    private EmployeeRepo repo;

	@Override
	protected PersonRepo<Employee, Integer> getRepo() {
		return repo;
	}

}