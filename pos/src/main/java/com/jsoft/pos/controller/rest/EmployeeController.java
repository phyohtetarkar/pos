package com.jsoft.pos.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsoft.pos.entity.Employee;
import com.jsoft.pos.service.EmployeeService;
import com.jsoft.pos.service.PersonService;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends PersonController<Employee, Integer> {

	@Autowired
    private EmployeeService service;

	@Override
	protected PersonService<Employee, Integer> getService() {
		return service;
	}

}