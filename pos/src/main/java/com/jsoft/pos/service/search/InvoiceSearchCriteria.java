package com.jsoft.pos.service.search;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class InvoiceSearchCriteria implements SearchCriteria {

	private LocalDate dateFrom;
	private LocalDate dateTo;

	private int offset;
	private int limit;

	public InvoiceSearchCriteria(int offset, int limit) {
		super();
		this.offset = offset;
		this.limit = limit;
	}

	@Override
	public String getWhere() {
		StringBuffer sb = new StringBuffer();

		if (dateFrom != null && dateTo != null) {
			sb.append("and ");
			sb.append("t.trade.eventDate between :df and :dt ");
		}

		return sb.toString();
	}

	@Override
	public Map<String, Object> getParams() {
		Map<String, Object> params = new HashMap<>();

		if (dateFrom != null && dateTo != null) {
			params.put("df", dateFrom);
			params.put("dt", dateTo);
		}

		return params;
	}

	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public int getLimit() {
		return limit;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

}