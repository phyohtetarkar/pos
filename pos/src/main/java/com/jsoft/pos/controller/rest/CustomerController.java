package com.jsoft.pos.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jsoft.pos.entity.Customer;
import com.jsoft.pos.service.CustomerService;
import com.jsoft.pos.service.PersonService;

@RestController
public class CustomerController extends PersonController<Customer> {

	@Autowired
    private CustomerService service;

	@Override
	protected PersonService<Customer> getService() {
		return service;
	}

}