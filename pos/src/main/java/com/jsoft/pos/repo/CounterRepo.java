package com.jsoft.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsoft.pos.entity.Counter;

public interface CounterRepo extends JpaRepository<Counter, Integer> {

}