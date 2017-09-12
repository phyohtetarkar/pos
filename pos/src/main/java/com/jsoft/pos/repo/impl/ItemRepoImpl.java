package com.jsoft.pos.repo.impl;

import com.jsoft.pos.entity.Item;

public class ItemRepoImpl extends AbstractSearchRepo<Item> {

    public ItemRepoImpl() {
    	super(Item.class);
    }

	@Override
	protected String getBaseQuery() {
		return null;
	}

}