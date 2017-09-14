package com.jsoft.pos.service.search;

import java.util.Map;

public class InvoiceSearchCriteria implements SearchCriteria {

	private int offset;
	private int limit;

	public InvoiceSearchCriteria(int offset, int limit) {
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

}