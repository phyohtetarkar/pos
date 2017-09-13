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

import com.jsoft.pos.entity.Payment;
import com.jsoft.pos.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
    private PaymentService service;

	@GetMapping
	public ResponseEntity<List<Payment>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<Payment> findById(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.findById(id));
	}

	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Payment payment) {		
		service.save(payment);
		
		if (payment.getId() > 0) {
			return ResponseEntity.ok("Saved!");
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}