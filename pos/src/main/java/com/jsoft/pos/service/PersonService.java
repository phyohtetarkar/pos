package com.jsoft.pos.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Person;
import com.jsoft.pos.repo.PersonRepo;
import com.jsoft.pos.service.search.SearchCriteria;

@Transactional
public abstract class PersonService<T extends Person> {

	protected abstract PersonRepo<T> getRepo();
	
	public List<T> search(SearchCriteria crt) {
		return getRepo().search(crt.getWhere(), crt.getParams(), crt.getOffset(), crt.getLimit());
	}
	
	public List<T> findAll(int offset, int limit) {
		return getRepo().findByDeletedFalse(new PageRequest(offset, limit, new Sort("id")));
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