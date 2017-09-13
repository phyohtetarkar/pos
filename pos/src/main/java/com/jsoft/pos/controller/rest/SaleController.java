package com.jsoft.pos.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsoft.pos.entity.Sale;
import com.jsoft.pos.service.SaleService;
import com.jsoft.pos.service.TradeService;

@RestController
@RequestMapping("/sale")
public class SaleController extends TradeController<Sale> {

	@Autowired
    private SaleService service;

	@Override
	protected TradeService<Sale> getService() {
		return service;
	}

}