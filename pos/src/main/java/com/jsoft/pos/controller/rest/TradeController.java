package com.jsoft.pos.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsoft.pos.entity.Trade;
import com.jsoft.pos.service.TradeService;

public abstract class TradeController<T extends Trade> {

    protected abstract TradeService<T> getService();
    
    @GetMapping("/find/{id}")
	public ResponseEntity<T> findById(@PathVariable("id") int id) {
		return ResponseEntity.ok(getService().findById(id));
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody T trade) {		
		getService().save(trade);
		
		if (trade.getId() > 0) {
			return ResponseEntity.ok("Saved!");
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}