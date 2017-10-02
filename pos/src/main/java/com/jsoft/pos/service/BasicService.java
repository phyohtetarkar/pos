package com.jsoft.pos.service;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BasicService<T, ID extends Serializable> {
	
	protected abstract JpaRepository<T, ID> getRepo();
	
	public T findById(ID id) {
		return getRepo().findOne(id);
	}

	public void save(T t) {
		getRepo().save(t);
	}
}
