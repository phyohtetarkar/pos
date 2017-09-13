package com.jsoft.pos.service.search;

import java.util.Map;

public interface SearchCriteria {

	public String getWhere();

	public Map<String, Object> getParams();

	public int getOffset();

	public int getLimit();

}
