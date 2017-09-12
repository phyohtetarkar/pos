package com.jsoft.pos.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Person;
import com.jsoft.pos.repo.PersonRepo;

@Transactional
public abstract class PersonService<T extends Person> {

	protected abstract PersonRepo<T> getRepo();

	public T findById(int id) {
		return getRepo().findOne(id);
	}

	public List<T> findByNameLike(String name, int page, int limit) {		
		return getRepo().findByNameLike(name.concat("%"), new PageRequest(page, limit));
	}

	public void save(T person) {
		getRepo().save(person);
	}

	public void delete(int id) {
	
	}

}