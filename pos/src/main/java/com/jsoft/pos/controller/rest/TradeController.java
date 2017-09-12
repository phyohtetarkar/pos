package com.jsoft.pos.controller.rest;

import com.jsoft.pos.entity.Trade;
import com.jsoft.pos.service.TradeService;

public abstract class TradeController<T extends Trade> {

    protected abstract TradeService<T> getService();
    
}