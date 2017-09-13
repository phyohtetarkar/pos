package com.jsoft.pos.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.jsoft.pos.entity.Trade;

@NoRepositoryBean
public interface TradeRepo<T extends Trade> extends JpaRepository<T, Long>, SearchableRepository<T> {
	List<T> findByEventDateBetweenAndDeletedFalse(LocalDate dateFrom, LocalDate dateTo, Pageable pagable);
}