package com.jsoft.pos.repo.impl;

import com.jsoft.pos.entity.Purchase;

public class PurchaseRepoImpl extends AbstractSearchRepo<Purchase> {

    public PurchaseRepoImpl() {
    	super(Purchase.class);
    }

	@Override
	protected String getBaseQuery() {
		return null;
	}

}