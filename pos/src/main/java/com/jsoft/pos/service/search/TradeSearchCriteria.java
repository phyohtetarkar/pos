package com.jsoft.pos.service.search;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TradeSearchCriteria implements SearchCriteria {

	private LocalDate dateFrom;
	private LocalDate dateTo;
	private int employeeId;

	private int offset;
	private int limit;

	public TradeSearchCriteria(int offset, int limit) {
		super();
		this.offset = offset;
		this.limit = limit;
	}

	@Override
	public String getWhere() {
		StringBuffer sb = new StringBuffer();
		
		if (employeeId > 0) {
			sb.append("and ");
			sb.append("t.employee.id = :employeeId ");
		}

		sb.append("and ");
		sb.append("t.eventDate between :df and :dt ");

		return sb.toString();
	}

	@Override
	public Map<String, Object> getParams() {
		Map<String, Object> params = new HashMap<>();
		
		if (employeeId > 0) {
			params.put("employeeId", employeeId);
		}

		params.put("df", dateFrom);
		params.put("dt", dateTo);

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

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}