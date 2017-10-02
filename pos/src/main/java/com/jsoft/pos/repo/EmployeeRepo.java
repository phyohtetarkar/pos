package com.jsoft.pos.repo;

import com.jsoft.pos.entity.Employee;

public interface EmployeeRepo extends PersonRepo<Employee, Integer> {
	Employee findByLoginId(String loginId);
}