package com.jsoft.pos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Invoice;
import com.jsoft.pos.repo.InvoiceRepo;
import com.jsoft.pos.service.search.InvoiceSearch;

@Service
@Transactional
public class InvoiceService extends BasicService<Invoice, Long> {

	@Autowired
    private InvoiceRepo repo;
	
	public List<Invoice> search(String dateFrom, String dateTo, int offset, int limit) {
		InvoiceSearch search = new InvoiceSearch(offset, limit);
		
		if ((null != dateFrom && !dateFrom.isEmpty()) && 
				(null != dateTo && !dateTo.isEmpty())) {
			search.setDateFrom(LocalDate.parse(dateFrom));
    			search.setDateTo(LocalDate.parse(dateTo));
		}
		return repo.search(search);
	}
	
	public long count(String dateFrom, String dateTo) {
		InvoiceSearch search = new InvoiceSearch(0, 0);
		
		if ((null != dateFrom && !dateFrom.isEmpty()) && 
				(null != dateTo && !dateTo.isEmpty())) {
			search.setDateFrom(LocalDate.parse(dateFrom));
    			search.setDateTo(LocalDate.parse(dateTo));
		}
		
		return repo.count(search);
	}

    public void delete(long id) {
        // TODO implement here
    }

	@Override
	protected JpaRepository<Invoice, Long> getRepo() {
		return repo;
	}

}