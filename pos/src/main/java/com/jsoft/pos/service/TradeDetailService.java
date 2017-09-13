package com.jsoft.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.TradeDetail;
import com.jsoft.pos.repo.TradeDetailRepo;

@Service
@Transactional
public class TradeDetailService {

	@Autowired
	private TradeDetailRepo repo;

	public TradeDetail findById(long id) {
		return repo.findOne(id);
	}

	public void save(TradeDetail tradeDetail) {
		repo.save(tradeDetail);
	}

}