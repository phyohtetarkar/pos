package com.jsoft.pos.service.search;

import java.util.Map;

public class SearchCriteria {

	private String where;
	private Map<String, Object> params;
	private int offset;
	private int limit;

	public SearchCriteria(String where, Map<String, Object> params, int offset, int limit) {
		super();
		this.where = where;
		this.params = params;
		this.offset = offset;
		this.limit = limit;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
