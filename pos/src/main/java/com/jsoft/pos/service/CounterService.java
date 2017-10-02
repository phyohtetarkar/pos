package com.jsoft.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Counter;
import com.jsoft.pos.repo.CounterRepo;

@Service
@Transactional
public class CounterService extends BasicService<Counter, Integer>{

	@Autowired
    private CounterRepo repo;

    public List<Counter> findAll() {
        return repo.findByDeletedFalse(new Sort("id"));
    }

    public void delete(int id) {
        // TODO implement here
    }

	@Override
	protected JpaRepository<Counter, Integer> getRepo() {
		return repo;
	}

}