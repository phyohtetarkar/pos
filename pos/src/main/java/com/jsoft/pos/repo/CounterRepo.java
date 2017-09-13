package com.jsoft.pos.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jsoft.pos.entity.Counter;

public interface CounterRepo extends JpaRepository<Counter, Integer> {
	List<Counter> findByDeletedFalse(Sort sort);
}