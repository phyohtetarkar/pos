package com.jsoft.pos.controller.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsoft.pos.entity.Person;
import com.jsoft.pos.service.PersonService;

public abstract class PersonController<T extends Person> {

	protected abstract PersonService<T> getService();

	@GetMapping
	public ResponseEntity<List<T>> findAll(@RequestParam("page") int page, 
			@RequestParam("limit") int limit) {
		return ResponseEntity.ok(getService().findAll(page, limit));
	}

	@GetMapping("/search")
	public ResponseEntity<List<T>> findByName(@RequestParam("name") String name, 
			@RequestParam("page") int page,
			@RequestParam("limit") int limit) {
		
		return ResponseEntity.ok(getService().findByName(name, page, limit));
	}

	@PostMapping
	public ResponseEntity<String> save(@RequestBody T person) {
		getService().save(person);

		if (person.getId() > 0) {
			return ResponseEntity.ok("Saved!");
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}