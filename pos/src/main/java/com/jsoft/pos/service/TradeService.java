package com.jsoft.pos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Trade;
import com.jsoft.pos.repo.TradeRepo;

@Transactional
public abstract class TradeService<T extends Trade> {

	protected abstract TradeRepo<T> getRepo();
	
	public List<T> search(LocalDate dateFrom, LocalDate dateTo, int page, int limit) {
		return getRepo().findByEventDateBetweenAndDeletedFalse(dateFrom, dateTo, 
				new PageRequest(page, limit, new Sort("id")));
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