package com.jsoft.pos.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsoft.pos.entity.TradeDetail;
import com.jsoft.pos.service.TradeDetailService;

@RestController
@RequestMapping("/tradeDetail")
public class TradeDetailController {

	@Autowired
    private TradeDetailService service;

	@GetMapping("/search/{id}")
	public ResponseEntity<TradeDetail> findById(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.findById(id));
	}
}