package com.jsoft.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Category;
import com.jsoft.pos.repo.CategoryRepo;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryRepo repo;
	
	public List<Category> findAll() {
		return repo.findByIsDeletedFalse(new Sort("id"));
	}

	public Category findById(int id) {
		return repo.findOne(id);
	}

	public List<Category> findByName(String name) {
		return repo.findByNameLikeIgnoreCaseAndIsDeletedFalse(name.concat("%"), new Sort("id"));
	}

	public void save(Category category) {
		repo.save(category);
	}

	public void delete(int id) {
		// TODO implement here
	}

}