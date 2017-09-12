package com.jsoft.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.pos.entity.Sale;
import com.jsoft.pos.repo.SaleRepo;
import com.jsoft.pos.repo.TradeRepo;

@Service
public class SaleService extends TradeService<Sale> {

	@Autowired
    private SaleRepo repo;

	@Override
	protected TradeRepo<Sale> getRepo() {
		return repo;
	}

}