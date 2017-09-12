package com.jsoft.pos.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jsoft.pos.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	List<Category> findByNameLike(String name, Pageable pagable);
}