package com.jsoft.pos.service.search;

import java.util.Map;

public interface Searchable {

    public String getWhere();

    public Map<String, Object> getParam();

    public int getFirstResult();

    public int getMaxResult();

}