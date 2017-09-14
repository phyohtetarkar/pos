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

import com.jsoft.pos.entity.Item;
import com.jsoft.pos.service.ItemService;
import com.jsoft.pos.service.search.ItemSearchCriteria;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
    private ItemService service;
	
	@GetMapping("/search")
	public ResponseEntity<List<Item>> search(@RequestParam("code") String code, 
			@RequestParam("name") String name, 
			@RequestParam("categoryId") int categoryId,
			@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
		
		ItemSearchCriteria crt = new ItemSearchCriteria(offset, limit);
		crt.setCode(code);
		crt.setName(name);
		crt.setCategoryId(categoryId);
		
		return ResponseEntity.ok(service.search(crt));
	}

	@GetMapping("/find")
	public ResponseEntity<Item> findByCode(@RequestParam("code") String code) {
		return ResponseEntity.ok(service.findByCode(code));
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Item> findById(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Item item) {		
		service.save(item);
		
		if (item.getId() > 0) {
			return ResponseEntity.ok("Saved!");
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}