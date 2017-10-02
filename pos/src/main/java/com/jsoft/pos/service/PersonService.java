package com.jsoft.pos.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Person;
import com.jsoft.pos.repo.PersonRepo;
import com.jsoft.pos.service.search.PersonSearchCriteria;

@Transactional
public abstract class PersonService<T extends Person, ID extends Serializable> extends BasicService<T, ID> {

	protected abstract PersonRepo<T, ID> getRepo();
	
	public List<T> search(String name, int offset, int limit) {
		PersonSearchCriteria crt = new PersonSearchCriteria(offset, limit);
		crt.setName(name);
		return getRepo().search(crt);
	}
	
	public long count(String name) {
		PersonSearchCriteria crt = new PersonSearchCriteria(0, 0);
		crt.setName(name);
		return getRepo().count(crt);
	}

	public void delete(int id) {
		
	}

}