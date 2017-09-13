package com.jsoft.pos.service.search;

import com.jsoft.pos.annotation.SearchParam;

public class ItemSearch {

	@SearchParam(paramName = "code")
	private String code;
	@SearchParam(paramName = "name")
	private String name;
	@SearchParam(paramName = "category.id")
	private int categoryId;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}