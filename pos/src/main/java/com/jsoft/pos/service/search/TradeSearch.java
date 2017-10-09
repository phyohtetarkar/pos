package com.jsoft.pos.service.search;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TradeSearch extends Search {

	private LocalDate dateFrom;
	private LocalDate dateTo;
	private int employeeId;
	
	public TradeSearch() {
		super(0, 0);
	}

	public TradeSearch(int offset, int limit) {
		super(offset, limit);
	}

	@Override
	public String getWhere() {
		StringBuffer sb = new StringBuffer();
		
		if (employeeId > 0) {
			sb.append("and ");
			sb.append("t.employee.id = :employeeId ");
		}

		if (dateFrom != null && dateTo != null) {
			sb.append("and ");
			sb.append("t.eventDate between :df and :dt ");
		}

		return sb.toString();
	}

	@Override
	public Map<String, Object> getParams() {
		Map<String, Object> params = new HashMap<>();
		
		if (employeeId > 0) {
			params.put("employeeId", employeeId);
		}

		if (dateFrom != null && dateTo != null) {
			params.put("df", dateFrom);
			params.put("dt", dateTo);
		}

		return params;
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

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
}