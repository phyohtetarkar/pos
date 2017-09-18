package com.jsoft.pos.service;

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
	
	public List<Invoice> search(InvoiceSearchCriteria crt) {
		return repo.search(crt.getWhere(), crt.getParams(), 
				crt.getOffset(), crt.getLimit());
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