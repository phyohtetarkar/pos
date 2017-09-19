package com.jsoft.pos.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Trade;
import com.jsoft.pos.repo.TradeRepo;
import com.jsoft.pos.service.search.SearchCriteria;
import com.jsoft.pos.service.search.TradeSearchCriteria;

@Transactional
public abstract class TradeService<T extends Trade> {

	protected abstract TradeRepo<T> getRepo();
	
	public List<T> search(TradeSearchCriteria crt) {
		return getRepo().search(crt.getWhere(), crt.getParams(), crt.getOffset(), crt.getLimit());
	}
	
	public long count(SearchCriteria crt) {
		return getRepo().count(crt.getWhere(), crt.getParams());
	}

	public T findById(long id) {
		return getRepo().findOne(id);
	}

	public void save(T trade) {
		getRepo().save(trade);
	}

	public void delete(long id) {

	}

}