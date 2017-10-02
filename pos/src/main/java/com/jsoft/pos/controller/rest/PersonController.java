package com.jsoft.pos.controller.rest;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsoft.pos.entity.Person;
import com.jsoft.pos.service.PersonService;

public abstract class PersonController<T extends Person, ID extends Serializable> {

	protected abstract PersonService<T, ID> getService();

	@GetMapping("/search")
	public ResponseEntity<List<T>> search(@RequestParam("name") String name, 
			@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		
		return ResponseEntity.ok(getService().search(name, offset, limit));
	}
	
	@GetMapping("/count")
	public ResponseEntity<Long> count(@RequestParam("name") String name) {
		
		return ResponseEntity.ok(getService().count(name));
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<T> findById(@PathVariable("id") ID id) {
		return ResponseEntity.ok(getService().findById(id));
	}

	@PostMapping
	public ResponseEntity<String> save(@RequestBody T person) {
		getService().save(person);

		if (person.getId() > 0) {
			return ResponseEntity.ok("Saved!");
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}