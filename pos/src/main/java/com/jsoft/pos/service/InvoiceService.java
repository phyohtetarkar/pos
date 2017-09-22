package com.jsoft.pos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Invoice;
import com.jsoft.pos.repo.InvoiceRepo;
import com.jsoft.pos.service.search.InvoiceSearchCriteria;

@Service
@Transactional
public class InvoiceService {

	@Autowired
    private InvoiceRepo repo;
	
	public List<Invoice> search(String dateFrom, String dateTo, int offset, int limit) {
		InvoiceSearchCriteria crt = new InvoiceSearchCriteria(offset, limit);
		
		if ((null != dateFrom && !dateFrom.isEmpty()) && 
				(null != dateTo && !dateTo.isEmpty())) {
			crt.setDateFrom(LocalDate.parse(dateFrom));
    			crt.setDateTo(LocalDate.parse(dateTo));
		}
		return repo.search(crt);
	}
	
	public long count(String dateFrom, String dateTo) {
		InvoiceSearchCriteria crt = new InvoiceSearchCriteria(0, 0);
		
		if ((null != dateFrom && !dateFrom.isEmpty()) && 
				(null != dateTo && !dateTo.isEmpty())) {
			crt.setDateFrom(LocalDate.parse(dateFrom));
    			crt.setDateTo(LocalDate.parse(dateTo));
		}
		
		return repo.count(crt);
	}

    public Invoice findById(long id) {
        return repo.findOne(id);
    }

    public void save(Invoice invoice) {
    		repo.save(invoice);
    }

    public void delete(long id) {
        // TODO implement here
    }

}