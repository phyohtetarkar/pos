package com.jsoft.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Item;
import com.jsoft.pos.repo.ItemRepo;

@Service
@Transactional
public class ItemService {

	@Autowired
    private ItemRepo repo;

    public Item findById(int id) {
        return repo.findOne(id);
    }

    public Item findByCode(String code) {
        return repo.findByCode(code);
    }

    public void save(Item item) {
    		repo.save(item);
    }

    public void delete(int id) {
        // TODO implement here
    }

}