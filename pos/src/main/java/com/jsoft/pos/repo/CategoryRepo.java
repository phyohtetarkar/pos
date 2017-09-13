package com.jsoft.pos.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jsoft.pos.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	List<Category> findByIsDeletedFalse(Sort sort);
	List<Category> findByNameLikeIgnoreCaseAndIsDeletedFalse(String name, Sort sort);
}