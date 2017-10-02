package com.jsoft.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Category;
import com.jsoft.pos.repo.CategoryRepo;

@Service
@Transactional
public class CategoryService extends BasicService<Category, Integer> {

	@Autowired
	private CategoryRepo repo;
	
	public List<Category> findAll() {
		return repo.findByDeletedFalse(new Sort("id"));
	}

	public List<Category> findByName(String name) {
		return repo.findByNameLikeIgnoreCaseAndDeletedFalse(name.concat("%"), new Sort("id"));
	}

	public void delete(int id) {
		// TODO implement here
	}

	@Override
	protected JpaRepository<Category, Integer> getRepo() {
		return repo;
	}

}