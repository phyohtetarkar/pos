package com.jsoft.pos.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jsoft.pos.entity.Purchase;
import com.jsoft.pos.service.PurchaseService;
import com.jsoft.pos.service.TradeService;

@RestController
public class PurchaseController extends TradeController<Purchase> {

	@Autowired
    private PurchaseService service;

	@Override
	protected TradeService<Purchase> getService() {
		return service;
	}

}