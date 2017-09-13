package com.jsoft.pos.service.search;

import java.time.LocalDate;
import java.util.Map;

public class TradeSearch implements SearchCriteria {

	private LocalDate dateFrom;
	private LocalDate dateTo;

	private int offset;
	private int limit;

	public TradeSearch(int offset, int limit) {
		super();
		this.offset = offset;
		this.limit = limit;
	}

	@Override
	public String getWhere() {
		return null;
	}

	@Override
	public Map<String, Object> getParams() {
		return null;
	}

	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public int getLimit() {
		return limit;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

}