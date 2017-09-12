package com.jsoft.pos.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jsoft.pos.service.TradeDetailService;

@RestController
public class TradeDetailController {

	@Autowired
    private TradeDetailService service;

}