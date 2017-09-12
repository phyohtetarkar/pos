package com.jsoft.pos.service;

import java.util.Set;

import com.jsoft.pos.entity.Person;
import com.jsoft.pos.repo.PersonRepo;

public abstract class PersonService<T extends Person> {

    protected abstract PersonRepo<T> getRepo();

    public T findById(int id) {
        return getRepo().findOne(id);
    }

    public Set<T> findByNameLike(String name) {
        return null;
    }

    public void save(T person) {
    	getRepo().save(person);
    }

    public void delete(int id) {
    }

}