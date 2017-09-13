package com.jsoft.pos.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Person;
import com.jsoft.pos.repo.PersonRepo;

@Transactional
public abstract class PersonService<T extends Person> {

	protected abstract PersonRepo<T> getRepo();
	
	public List<T> findAll(int page, int limit) {
		return getRepo().findByIsDeletedFalse(new PageRequest(page, limit, new Sort("id")));
	}

	public T findById(int id) {
		return getRepo().findOne(id);
	}

	public List<T> findByName(String name, int page, int limit) {		
		return getRepo().findByNameLikeIgnoreCaseAndIsDeletedFalse(name.concat("%"), new PageRequest(page, limit, new Sort("id")));
	}

	public void save(T person) {
		getRepo().save(person);
	}

	public void delete(int id) {
	
	}

}