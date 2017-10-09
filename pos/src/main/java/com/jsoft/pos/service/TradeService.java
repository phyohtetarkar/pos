package com.jsoft.pos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Trade;
import com.jsoft.pos.repo.TradeRepo;
import com.jsoft.pos.service.search.TradeSearch;

@Transactional
public abstract class TradeService<T extends Trade> {

	protected abstract TradeRepo<T> getRepo();
	
	public List<T> search(String dateFrom, String dateTo, int employeeId, int offset, int limit) {
		TradeSearch search = new TradeSearch(offset, limit);
		
		if ((null != dateFrom && !dateFrom.isEmpty()) && 
				(null != dateTo && !dateTo.isEmpty())) {
			search.setDateFrom(LocalDate.parse(dateFrom));
    			search.setDateTo(LocalDate.parse(dateTo));
		}
		
		search.setEmployeeId(employeeId);
		
		return getRepo().search(search);
	}
	
	public long count(String dateFrom, String dateTo, int employeeId) {
		TradeSearch search = new TradeSearch();
		
		if ((null != dateFrom && !dateFrom.isEmpty()) && 
				(null != dateTo && !dateTo.isEmpty())) {
			search.setDateFrom(LocalDate.parse(dateFrom));
    			search.setDateTo(LocalDate.parse(dateTo));
		}
		
		search.setEmployeeId(employeeId);
		
		return getRepo().count(search);
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