package com.jsoft.pos.service.search;

import java.util.HashMap;
import java.util.Map;

public class PersonSearchCriteria implements SearchCriteria {

	private String name;

	private int offset;
	private int limit;

	public PersonSearchCriteria(int offset, int limit) {
		super();
		this.offset = offset;
		this.limit = limit;
	}

	@Override
	public String getWhere() {
		StringBuffer sb = new StringBuffer();
		
		if (null != name && !name.isEmpty()) {
			sb.append("and ");
			sb.append("t.name like :name ");
		}
		
		return null;
	}

	@Override
	public Map<String, Object> getParams() {
		Map<String, Object> params = new HashMap<>();
		
		if (null != name && !name.isEmpty()) {
			params.put("name", name.concat("%"));
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}