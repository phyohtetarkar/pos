package com.jsoft.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.TradeDetail;
import com.jsoft.pos.repo.TradeDetailRepo;

@Service
@Transactional
public class TradeDetailService {

	@Autowired
	private TradeDetailRepo repo;
	
	public List<TradeDetail> findAll(int page, int limit) {
		return repo.findByDeletedFalse(new PageRequest(page, limit, new Sort("id")));
	}

	public TradeDetail findById(long id) {
		return repo.findOne(id);
	}

	public void save(TradeDetail tradeDetail) {
		repo.save(tradeDetail);
	}

}