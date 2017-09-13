package com.jsoft.pos.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsoft.pos.entity.Counter;
import com.jsoft.pos.service.CounterService;

@RestController
@RequestMapping("/counter")
public class CounterController {

	@Autowired
    private CounterService service;
	
	@GetMapping
	public ResponseEntity<List<Counter>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Counter> findById(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.findById(id));
	}

	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Counter counter) {		
		service.save(counter);
		
		if (counter.getId() > 0) {
			return ResponseEntity.ok("Saved!");
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

}