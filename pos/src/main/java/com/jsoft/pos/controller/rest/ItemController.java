package com.jsoft.pos.controller.rest;

import java.util.List;

import javax.servlet.http.Part;

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
		
		return ResponseEntity.ok(service.search(code, name, categoryId, offset, limit));
	}
	
	@GetMapping("/count")
	public ResponseEntity<Long> count(@RequestParam("code") String code, 
			@RequestParam("name") String name, 
			@RequestParam("categoryId") int categoryId) {
		
		return ResponseEntity.ok(service.count(code, name, categoryId));
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
		try {
			Item temp = service.findByCode(item.getCode());
			
			if (temp != null && temp.getId() != item.getId()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Duplicate Item Code!");
			}
			
			service.save(item);
			
			if (item.getId() > 0) {
				return ResponseEntity.ok("Saved!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not save item!");
	}
	
	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("image") Part part) {
		
		if (null != part) {
			return ResponseEntity.ok(String.valueOf(part.getSize()));
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Image upload error!");
	}
}