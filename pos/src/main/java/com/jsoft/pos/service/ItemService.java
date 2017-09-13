package com.jsoft.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Item;
import com.jsoft.pos.repo.ItemRepo;
import com.jsoft.pos.service.search.ItemSearch;
import com.jsoft.pos.service.search.SearchCriteria;
import com.jsoft.pos.util.JPACriteria;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemRepo repo;

	public List<Item> search(ItemSearch sch, int offset, int limit) {
		SearchCriteria criteria = JPACriteria.builder().of(sch).likeMatches("name").build(offset, limit);
		return repo.search(criteria);
	}

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