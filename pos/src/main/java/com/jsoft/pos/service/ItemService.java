package com.jsoft.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Item;
import com.jsoft.pos.repo.ItemRepo;
import com.jsoft.pos.service.search.SearchCriteria;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemRepo repo;

	public List<Item> search(SearchCriteria crt) {
		return repo.search(crt.getWhere(), crt.getParams(), crt.getOffset(), crt.getLimit());
	}
	
	public long count(SearchCriteria crt) {
		return repo.count(crt.getWhere(), crt.getParams());
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