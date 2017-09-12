package com.jsoft.pos.repo.impl;

import com.jsoft.pos.entity.Invoice;

public class InvoiceRepoImpl extends AbstractSearchRepo<Invoice> {

    public InvoiceRepoImpl() {
		super(Invoice.class);
	}

}