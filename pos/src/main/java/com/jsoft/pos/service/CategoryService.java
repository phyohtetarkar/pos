package com.jsoft.pos.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.pos.entity.Category;
import com.jsoft.pos.repo.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
    private CategoryRepo repo;

    public Category findById(int id) {
        // TODO implement here
        return null;
    }

    public Set<Category> findByNameLike(String name) {
        // TODO implement here
        return null;
    }

    public void save(Category category) {
        // TODO implement here
    }

    public void delete(int id) {
        // TODO implement here
    }

}