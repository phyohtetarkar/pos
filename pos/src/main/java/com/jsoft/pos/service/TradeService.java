package com.jsoft.pos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Trade;
import com.jsoft.pos.repo.TradeRepo;
import com.jsoft.pos.service.search.TradeSearchCriteria;

@Transactional
public abstract class TradeService<T extends Trade> {

	protected abstract TradeRepo<T> getRepo();
	
	public List<T> search(String dateFrom, String dateTo, int employeeId, int offset, int limit) {
		TradeSearchCriteria crt = new TradeSearchCriteria(offset, limit);
		
		if ((null != dateFrom && !dateFrom.isEmpty()) && 
				(null != dateTo && !dateTo.isEmpty())) {
			crt.setDateFrom(LocalDate.parse(dateFrom));
    			crt.setDateTo(LocalDate.parse(dateTo));
		}
		
		crt.setEmployeeId(employeeId);
		
		return getRepo().search(crt);
	}
	
	public long count(String dateFrom, String dateTo, int employeeId) {
		TradeSearchCriteria crt = new TradeSearchCriteria(0, 0);
		
		if ((null != dateFrom && !dateFrom.isEmpty()) && 
				(null != dateTo && !dateTo.isEmpty())) {
			crt.setDateFrom(LocalDate.parse(dateFrom));
    			crt.setDateTo(LocalDate.parse(dateTo));
		}
		
		crt.setEmployeeId(employeeId);
		
		return getRepo().count(crt);
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