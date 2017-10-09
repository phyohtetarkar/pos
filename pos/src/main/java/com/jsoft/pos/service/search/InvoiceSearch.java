package com.jsoft.pos.service.search;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class InvoiceSearch extends Search {

	private LocalDate dateFrom;
	private LocalDate dateTo;
	
	public InvoiceSearch() {
		super(0, 0);
	}
	
	public InvoiceSearch(int offset, int limit) {
		super(offset, limit);
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

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

}