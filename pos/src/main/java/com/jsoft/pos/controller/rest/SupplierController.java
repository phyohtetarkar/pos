package com.jsoft.pos.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsoft.pos.entity.Supplier;
import com.jsoft.pos.service.PersonService;
import com.jsoft.pos.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController extends PersonController<Supplier> {

	@Autowired
    private SupplierService service;

	@Override
	protected PersonService<Supplier> getService() {
		return service;
	}

}