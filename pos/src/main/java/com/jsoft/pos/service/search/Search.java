package com.jsoft.pos.service.search;

import java.util.Map;

public abstract class Search {

	private int offset;
	private int limit;

	protected Search(int offset, int limit) {
		this.offset = offset;
		this.limit = limit;
	}

	public abstract String getWhere();

	public abstract Map<String, Object> getParams();

	public int getOffset() {
		return offset;
	}

	public int getLimit() {
		return limit;
	}

}
