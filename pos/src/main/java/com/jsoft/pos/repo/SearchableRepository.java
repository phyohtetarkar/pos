package com.jsoft.pos.repo;

import java.util.List;

import com.jsoft.pos.service.search.Search;

public interface SearchableRepository<T> {
	List<T> search(Search search);
	long count(Search search);
}