package com.jsoft.pos.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsoft.pos.entity.Employee;
import com.jsoft.pos.service.EmployeeService;

public class EmployeeTest {
	
	private static ConfigurableApplicationContext ctx;
	private EmployeeService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("spring-config.xml");
	}

	@Before
	public void setUp() throws Exception {
		service = ctx.getBean(EmployeeService.class);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		ctx.close();
	}

	@Test
	public void test1() {
		Employee emp = new Employee();
		emp.setName("Htet");
		
		service.save(emp);
		
		assertEquals(1, emp.getId());
	}
	
	@Test
	public void test2() {
		List<Employee> emps = service.findByName("Ht", 1, 10);
		
		assertNotEquals(0, emps.size());
		assertEquals("Htet", emps.get(0).getName());
	}

}
