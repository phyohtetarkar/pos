package com.jsoft.pos.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.jsoft.pos.entity.Person;

@NoRepositoryBean
public interface PersonRepo<T extends Person> extends JpaRepository<T, Integer>, SearchableRepository<T> {
	List<T> findByDeletedFalse(Pageable pagable);
	List<T> findByNameLikeIgnoreCaseAndDeletedFalse(String name, Pageable pagable);
}