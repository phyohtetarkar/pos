package com.jsoft.pos.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Person;
import com.jsoft.pos.repo.PersonRepo;
import com.jsoft.pos.service.search.PersonSearch;

@Transactional
public abstract class PersonService<T extends Person> extends BasicService<T, Integer> {

	protected abstract PersonRepo<T> getRepo();
	
	public List<T> search(String name, int offset, int limit) {
		PersonSearch search = new PersonSearch(offset, limit);
		search.setName(name);
		return getRepo().search(search);
	}
	
	public long count(String name) {
		PersonSearch search = new PersonSearch();
		search.setName(name);
		return getRepo().count(search);
	}

	public void delete(int id) {
		
	}

}