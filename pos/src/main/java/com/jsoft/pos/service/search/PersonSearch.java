package com.jsoft.pos.service.search;

import java.util.HashMap;
import java.util.Map;

public class PersonSearch extends Search {

	private String name;
	
	public PersonSearch() {
		super(0, 0);
	}

	public PersonSearch(int offset, int limit) {
		super(offset, limit);
	}

	@Override
	public String getWhere() {
		StringBuffer sb = new StringBuffer();
		
		if (name != null && !name.isEmpty()) {
			sb.append("and ");
			sb.append("upper(t.name) like upper(:name) ");
		}
		
		return sb.toString();
	}

	@Override
	public Map<String, Object> getParams() {
		Map<String, Object> params = new HashMap<>();
		
		if (name != null && !name.isEmpty()) {
			params.put("name", name.concat("%"));
		}
		
		return params;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
