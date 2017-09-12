package com.jsoft.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsoft.pos.entity.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, Long>, SearchableRepository<Invoice> {

}