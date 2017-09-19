package com.jsoft.pos.controller.rest;

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
import com.jsoft.pos.service.search.PersonSearchCriteria;

public abstract class PersonController<T extends Person> {

	protected abstract PersonService<T> getService();

	@GetMapping("/search")
	public ResponseEntity<List<T>> search(@RequestParam("name") String name, 
			@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		
		PersonSearchCriteria crt = new PersonSearchCriteria(offset, limit);
		crt.setName(name);
		
		return ResponseEntity.ok(getService().search(crt));
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<T> search(@PathVariable("id") int id) {
		return ResponseEntity.ok(getService().findById(id));
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