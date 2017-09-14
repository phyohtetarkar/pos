package com.jsoft.pos.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jsoft.pos.entity.TradeDetail;

public interface TradeDetailRepo extends JpaRepository<TradeDetail, Long> {
	List<TradeDetail> findByDeletedFalse(Pageable pagable);
}