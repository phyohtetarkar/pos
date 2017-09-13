package com.jsoft.pos.repo;

import java.util.List;

import com.jsoft.pos.service.search.SearchCriteria;

public interface SearchableRepository<T> {
	List<T> search(SearchCriteria criteria);
}