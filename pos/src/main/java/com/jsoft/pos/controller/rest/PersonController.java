package com.jsoft.pos.controller.rest;

import org.springframework.web.bind.annotation.RestController;

import com.jsoft.pos.entity.Person;
import com.jsoft.pos.service.PersonService;

@RestController
public abstract class PersonController<T extends Person> {

    protected abstract PersonService<T> getService();

}