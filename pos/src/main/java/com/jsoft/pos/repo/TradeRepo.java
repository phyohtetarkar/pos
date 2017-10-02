package com.jsoft.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.jsoft.pos.entity.Trade;

@NoRepositoryBean
public interface TradeRepo<T extends Trade> extends JpaRepository<T, Long>, SearchableRepository<T> {
	
}