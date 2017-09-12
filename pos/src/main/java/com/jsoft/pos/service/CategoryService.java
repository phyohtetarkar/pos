package com.jsoft.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Category;
import com.jsoft.pos.repo.CategoryRepo;

@Service
@Transactional
public class CategoryService {

	@Autowired
    private CategoryRepo repo;

    public Category findById(int id) {
        return repo.findOne(id);
    }

    public List<Category> findByNameLike(String name, int page, int limit) {
        return repo.findByNameLike(name.concat("&"), new PageRequest(page, limit));
    }

    public void save(Category category) {
    		repo.save(category);
    }

    public void delete(int id) {
        // TODO implement here
    }

}