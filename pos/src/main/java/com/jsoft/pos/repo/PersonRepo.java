package com.jsoft.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.jsoft.pos.entity.Person;

@NoRepositoryBean
public interface PersonRepo<T extends Person> extends JpaRepository<T, Integer>, SearchableRepository<T> {
	
}