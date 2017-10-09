package com.jsoft.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Item;
import com.jsoft.pos.repo.ItemRepo;
import com.jsoft.pos.service.search.ItemSearch;

@Service
@Transactional
public class ItemService extends BasicService<Item, Integer> {

	@Autowired
	private ItemRepo repo;

	public List<Item> search(String code, String name, int categoryId, int offset, int limit) {
		ItemSearch search = new ItemSearch(offset, limit);
		search.setCode(code);
		search.setName(name);
		search.setCategoryId(categoryId);
		
		return repo.search(search);
	}
	
	public long count(String code, String name, int categoryId) {
		ItemSearch search = new ItemSearch(0, 0);
		search.setCode(code);
		search.setName(name);
		search.setCategoryId(categoryId);
		return repo.count(search);
	}

	public Item findByCode(String code) {
		return repo.findByCodeAndDeletedFalse(code);
	}

	public void delete(int id) {
		// TODO implement here
	}

	@Override
	protected JpaRepository<Item, Integer> getRepo() {
		return repo;
	}

}