package com.jsoft.pos.controller.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsoft.pos.entity.Trade;
import com.jsoft.pos.service.TradeService;
import com.jsoft.pos.service.search.TradeSearchCriteria;

public abstract class TradeController<T extends Trade> {

    protected abstract TradeService<T> getService();
    
    @GetMapping("/search")
	public ResponseEntity<List<T>> search( 
			@RequestParam("dateFrom") String dateFrom, 
			@RequestParam("dateTo") String dateTo,
			@RequestParam("employeeId") int employeeId,
			@RequestParam("offset") int offset,
			@RequestParam("limit") int limit) {
    	
    		TradeSearchCriteria crt = new TradeSearchCriteria(offset, limit);
    		
    		if ((null != dateFrom && !dateFrom.isEmpty()) && 
    				(null != dateTo && !dateTo.isEmpty())) {
    			crt.setDateFrom(LocalDate.parse(dateFrom));
        		crt.setDateTo(LocalDate.parse(dateTo));
    		}
    		
    		crt.setEmployeeId(employeeId);
		
		return ResponseEntity.ok(getService().search(crt));
	}
    
    @GetMapping("/find/{id}")
	public ResponseEntity<T> findById(@PathVariable("id") int id) {
		return ResponseEntity.ok(getService().findById(id));
	}
    
    @GetMapping("/count")
	public ResponseEntity<Long> search( 
			@RequestParam("dateFrom") String dateFrom, 
			@RequestParam("dateTo") String dateTo,
			@RequestParam("employeeId") int employeeId) {
    	
    		TradeSearchCriteria crt = new TradeSearchCriteria(0, 0);
    		
    		if ((null != dateFrom && !dateFrom.isEmpty()) && 
    				(null != dateTo && !dateTo.isEmpty())) {
    			crt.setDateFrom(LocalDate.parse(dateFrom));
        		crt.setDateTo(LocalDate.parse(dateTo));
    		}
    		
    		crt.setEmployeeId(employeeId);
		
		return ResponseEntity.ok(getService().count(crt));
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody T trade) {		
		getService().save(trade);
		
		if (trade.getId() > 0) {
			return ResponseEntity.ok("Saved!");
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}