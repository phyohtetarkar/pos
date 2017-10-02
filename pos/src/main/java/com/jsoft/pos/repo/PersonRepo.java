package com.jsoft.pos.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.jsoft.pos.entity.Person;

@NoRepositoryBean
public interface PersonRepo<T extends Person, ID extends Serializable> extends JpaRepository<T, ID>, SearchableRepository<T> {
	
}