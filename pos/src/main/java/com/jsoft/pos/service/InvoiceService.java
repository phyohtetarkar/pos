package com.jsoft.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Invoice;
import com.jsoft.pos.repo.InvoiceRepo;

@Service
@Transactional
public class InvoiceService {

	@Autowired
    private InvoiceRepo repo;

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