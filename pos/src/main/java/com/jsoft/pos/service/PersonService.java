package com.jsoft.pos.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Person;
import com.jsoft.pos.repo.PersonRepo;
import com.jsoft.pos.service.search.PersonSearchCriteria;

@Transactional
public abstract class PersonService<T extends Person> {

	protected abstract PersonRepo<T> getRepo();
	
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

	public T findById(int id) {
		return getRepo().findOne(id);
	}

	public List<T> findByName(String name, int offset, int limit) {		
		return getRepo().findByNameLikeIgnoreCaseAndDeletedFalse(name.concat("%"), new PageRequest(offset, limit, new Sort("id")));
	}

	public void save(T person) {
		getRepo().save(person);
	}

	public void delete(int id) {
	
	}

}