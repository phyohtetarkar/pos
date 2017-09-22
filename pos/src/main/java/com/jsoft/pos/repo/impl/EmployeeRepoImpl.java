package com.jsoft.pos.repo.impl;

import com.jsoft.pos.entity.Employee;

public class EmployeeRepoImpl extends AbstractSearchRepo<Employee>{

	public EmployeeRepoImpl() {
		super(Employee.class);
	}

}
