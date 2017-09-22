package com.jsoft.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Item;
import com.jsoft.pos.repo.ItemRepo;
import com.jsoft.pos.service.search.ItemSearchCriteria;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemRepo repo;

	public List<Item> search(String code, String name, int categoryId, int offset, int limit) {
		ItemSearchCriteria crt = new ItemSearchCriteria(offset, limit);
		crt.setCode(code);
		crt.setName(name);
		crt.setCategoryId(categoryId);
		
		return repo.search(crt);
	}
	
	public long count(String code, String name, int categoryId) {
		ItemSearchCriteria crt = new ItemSearchCriteria(0, 0);
		crt.setCode(code);
		crt.setName(name);
		crt.setCategoryId(categoryId);
		return repo.count(crt);
	}

	public Item findById(int id) {
		return repo.findOne(id);
	}

	public Item findByCode(String code) {
		return repo.findByCodeAndDeletedFalse(code);
	}

	public void save(Item item) {
		repo.save(item);
	}

	public void delete(int id) {
		// TODO implement here
	}

}