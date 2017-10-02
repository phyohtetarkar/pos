package com.jsoft.pos.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsoft.pos.entity.Customer;
import com.jsoft.pos.service.CustomerService;
import com.jsoft.pos.service.PersonService;

@RestController
@RequestMapping("/customer")
public class CustomerController extends PersonController<Customer, Integer> {

	@Autowired
    private CustomerService service;

	@Override
	protected PersonService<Customer, Integer> getService() {
		return service;
	}

}