package com.jsoft.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.TradeDetail;
import com.jsoft.pos.repo.TradeDetailRepo;

@Service
@Transactional
public class TradeDetailService extends BasicService<TradeDetail, Long> {

	@Autowired
	private TradeDetailRepo repo;
	
	public List<TradeDetail> findAll(int offset, int limit) {
		return repo.findByDeletedFalse(new PageRequest(offset, limit, new Sort("id")));
	}

	@Override
	protected JpaRepository<TradeDetail, Long> getRepo() {
		return repo;
	}

}