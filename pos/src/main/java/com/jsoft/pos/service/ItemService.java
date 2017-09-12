package com.jsoft.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.pos.entity.Item;
import com.jsoft.pos.repo.ItemRepo;

@Service
public class ItemService {

	@Autowired
    private ItemRepo repo;

    public Item findById(int id) {
        // TODO implement here
        return null;
    }

    public Item findByCode(String code) {
        // TODO implement here
        return null;
    }

    public void save(Item item) {
        // TODO implement here
    }

    public void delete(int id) {
        // TODO implement here
    }

}