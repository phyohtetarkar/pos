package com.jsoft.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsoft.pos.entity.TradeDetail;

public interface TradeDetailRepo extends JpaRepository<TradeDetail, Long> {

}