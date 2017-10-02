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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsoft.pos.entity.Category;
import com.jsoft.pos.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
    private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Category> findById(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping("/find")
	public ResponseEntity<List<Category>> findByName(@RequestParam("name") String name) {
		return ResponseEntity.ok(service.findByName(name));
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Category category) {	
		try {
			service.save(category);
			
			if (category.getId() > 0) {
				return ResponseEntity.ok("Saved!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not save category!");
	}
}