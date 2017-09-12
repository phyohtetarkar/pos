package com.jsoft.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.pos.entity.Invoice;
import com.jsoft.pos.repo.InvoiceRepo;

@Service
public class InvoiceService {

	@Autowired
    private InvoiceRepo repo;

    public Invoice findById(long id) {
        // TODO implement here
        return null;
    }

    public void save(Invoice invoice) {
        // TODO implement here
    }

    public void delete(long id) {
        // TODO implement here
    }

}