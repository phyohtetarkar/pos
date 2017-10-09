package com.jsoft.pos.service.search;

import java.util.HashMap;
import java.util.Map;

public class ItemSearch extends Search {

	private String code;
	private String name;
	private int categoryId;
	
	public ItemSearch() {
		super(0, 0);
	}
	
	public ItemSearch(int offset, int limit) {
		super(offset, limit);
	}

	@Override
	public String getWhere() {
		StringBuffer sb = new StringBuffer();
		
		if (categoryId > 0) {
			sb.append("and ");
			sb.append("t.category.id = :categoryId ");
		}
		
		if (code != null && !code.isEmpty()) {
			sb.append("and ");
			sb.append("t.code = :code ");
		}
		
		if (name != null && !name.isEmpty()) {
			sb.append("and ");
			sb.append("upper(t.name) like upper(:name) ");
		}
		 
		return sb.toString();
	}

	@Override
	public Map<String, Object> getParams() {
		Map<String, Object> params = new HashMap<>();
		
		if (categoryId > 0) {
			params.put("categoryId", categoryId);
		}
		
		if (code != null && !code.isEmpty()) {
			params.put("code", code);
		}
		
		if (name != null && !name.isEmpty()) {
			params.put("name", name.concat("%"));
		}
	
		return params;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}