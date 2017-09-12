package com.jsoft.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.pos.entity.Purchase;
import com.jsoft.pos.repo.PurchaseRepo;
import com.jsoft.pos.repo.TradeRepo;

@Service
public class PurchaseService extends TradeService<Purchase> {

	@Autowired
    private PurchaseRepo repo;

	@Override
	protected TradeRepo<Purchase> getRepo() {
		return repo;
	}

}