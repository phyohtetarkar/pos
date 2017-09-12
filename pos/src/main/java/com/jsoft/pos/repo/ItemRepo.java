package com.jsoft.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsoft.pos.entity.Item;

public interface ItemRepo extends JpaRepository<Item, Integer>, SearchableRepository<Item> {

}