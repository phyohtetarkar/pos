package com.jsoft.pos.repo;

import com.jsoft.pos.entity.Employee;

public interface EmployeeRepo extends PersonRepo<Employee> {
	Employee findByLoginId(String loginId);
}