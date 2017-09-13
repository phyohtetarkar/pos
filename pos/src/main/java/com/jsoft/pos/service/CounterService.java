package com.jsoft.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Counter;
import com.jsoft.pos.repo.CounterRepo;

@Service
@Transactional
public class CounterService {

	@Autowired
    private CounterRepo repo;

    public List<Counter> findAll() {
        return repo.findByDeletedFalse(new Sort("id"));
    }

    public Counter findById(int id) {
        return repo.findOne(id);
    }

    public void save(Counter counter) {
    		repo.save(counter);
    }

    public void delete(int id) {
        // TODO implement here
    }

}