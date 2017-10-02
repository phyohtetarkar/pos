package com.jsoft.pos.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsoft.pos.entity.Invoice;
import com.jsoft.pos.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService service;
	
	@GetMapping("/search")
	public ResponseEntity<List<Invoice>> search(
			@RequestParam("dateFrom") String dateFrom, 
			@RequestParam("dateTo") String dateTo,
			@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
			
		return ResponseEntity.ok(service.search(dateFrom, dateTo, offset, limit));
	}
	
	@GetMapping("/count")
	public ResponseEntity<Long> count(@RequestParam("dateFrom") String dateFrom, 
			@RequestParam("dateTo") String dateTo) {
			
		return ResponseEntity.ok(service.count(dateFrom, dateTo));
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Invoice> findById(@PathVariable("id") long id) {
		return ResponseEntity.ok(service.findById(id));
	}
}
