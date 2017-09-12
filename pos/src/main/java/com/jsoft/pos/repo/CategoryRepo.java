package com.jsoft.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsoft.pos.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}