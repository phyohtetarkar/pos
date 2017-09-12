package com.jsoft.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.pos.entity.TradeDetail;
import com.jsoft.pos.repo.TradeDetailRepo;

@Service
public class TradeDetailService {

	@Autowired
    private TradeDetailRepo repo;

    public TradeDetail findById(long id) {
        // TODO implement here
        return null;
    }

    public void save(TradeDetail tradeDetail) {
        // TODO implement here
    }

}