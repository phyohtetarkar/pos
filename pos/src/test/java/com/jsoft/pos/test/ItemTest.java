package com.jsoft.pos.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsoft.pos.entity.Category;
import com.jsoft.pos.entity.Item;
import com.jsoft.pos.service.CategoryService;
import com.jsoft.pos.service.ItemService;
import com.jsoft.pos.service.search.ItemSearchCriteria;

public class ItemTest {
	
	private static ConfigurableApplicationContext ctx;
	private ItemService iService;
	private CategoryService cService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("spring-config.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		iService = ctx.getBean(ItemService.class);
		cService = ctx.getBean(CategoryService.class);
	}

	@Test
	public void test() {
		Category c = new Category();
		c.setName("Mobile");
		cService.save(c);
		
		assertEquals(1, c.getId());
		
		Item i = new Item();
		i.setName("iPhone");
		i.setCode("001");
		i.setCategory(c);
		
		iService.save(i);
		
		assertEquals(1, i.getId());
		
		
		ItemSearchCriteria crt = new ItemSearchCriteria(0, 10);
		crt.setName("iph");
		//sch.setCode("001");
		crt.setCategoryId(1);

		List<Item> items = iService.search(crt);
		
		Item it = iService.findByCode("001");
		
		assertEquals(1, items.size());
		assertEquals("iPhone", items.get(0).getName());
		assertNotNull(it);
	}

}
