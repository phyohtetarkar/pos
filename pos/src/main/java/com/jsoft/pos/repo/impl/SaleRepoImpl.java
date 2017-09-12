package com.jsoft.pos.repo.impl;

import com.jsoft.pos.entity.Sale;

public class SaleRepoImpl extends AbstractSearchRepo<Sale> {

    public SaleRepoImpl() {
    	super(Sale.class);
    }

	@Override
	protected String getBaseQuery() {
		return null;
	}

}