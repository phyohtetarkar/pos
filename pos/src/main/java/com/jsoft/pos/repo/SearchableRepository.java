package com.jsoft.pos.repo;

import java.util.List;
import java.util.Map;

public interface SearchableRepository<T> {
	List<T> search(String where, Map<String, Object> params, int offset, int limit);
}