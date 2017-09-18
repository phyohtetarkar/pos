package com.jsoft.pos.controller.rest;

import java.time.LocalDate;
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
import com.jsoft.pos.service.search.InvoiceSearchCriteria;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService service;
	
	@GetMapping("/search")
	public ResponseEntity<List<Invoice>> findByEventDate(
			@RequestParam("dateFrom") String dateFrom, 
			@RequestParam("dateTo") String dateTo,
			@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
			
		InvoiceSearchCriteria crt = new InvoiceSearchCriteria(offset, limit);
		
		if ((null != dateFrom && !dateFrom.isEmpty()) && 
				(null != dateTo && !dateTo.isEmpty())) {
			crt.setDateFrom(LocalDate.parse(dateFrom));
    			crt.setDateTo(LocalDate.parse(dateTo));
		}
		
		return ResponseEntity.ok(service.search(crt));
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Invoice> findById(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.findById(id));
	}
}
