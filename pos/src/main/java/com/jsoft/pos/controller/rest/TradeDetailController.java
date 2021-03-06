package com.jsoft.pos.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsoft.pos.entity.TradeDetail;
import com.jsoft.pos.service.TradeDetailService;

@RestController
@RequestMapping("/tradeDetail")
public class TradeDetailController {

	@Autowired
    private TradeDetailService service;
	
	@GetMapping
	public ResponseEntity<List<TradeDetail>> findAll(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
		return ResponseEntity.ok(service.findAll(offset, limit));
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<TradeDetail> findById(@PathVariable("id") long id) {
		return ResponseEntity.ok(service.findById(id));
	}
}