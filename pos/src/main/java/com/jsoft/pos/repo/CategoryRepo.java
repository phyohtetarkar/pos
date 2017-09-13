package com.jsoft.pos.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jsoft.pos.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	List<Category> findByDeletedFalse(Sort sort);
	List<Category> findByNameLikeIgnoreCaseAndDeletedFalse(String name, Sort sort);
}