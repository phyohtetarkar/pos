package com.jsoft.pos.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.pos.entity.Counter;
import com.jsoft.pos.repo.CounterRepo;

@Service
public class CounterService {

	@Autowired
    private CounterRepo repo;

    public Set<Counter> findAll() {
        // TODO implement here
        return null;
    }

    public Counter findById(int id) {
        // TODO implement here
        return null;
    }

    public void save(Counter counter) {
        // TODO implement here
    }

    public void delete(int id) {
        // TODO implement here
    }

}