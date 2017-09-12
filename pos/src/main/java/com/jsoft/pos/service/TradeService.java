package com.jsoft.pos.service;

import com.jsoft.pos.entity.Trade;
import com.jsoft.pos.repo.TradeRepo;

public abstract class TradeService<T extends Trade> {

    protected abstract TradeRepo<T> getRepo();

    public T findById(long id) {
        return getRepo().findOne(id);
    }

    public void save(T trade) {
    	getRepo().save(trade);
    }

    public void delete(long id) {
    	
    }

}