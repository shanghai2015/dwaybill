package com.daphne.dwaybill;

import com.daphne.dwaybill.domain.DposActivityLevel;
import com.daphne.dwaybill.repository.DposActivityLevelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DwaybillApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private DposActivityLevelRepository repository;

	@Test
	public void test() throws Exception {
		DposActivityLevel da = new DposActivityLevel();
        da.getUionPKID().setLevelNo("02");
        da.getUionPKID().setActivityType("test2");
		da.setLevelName("test2");
		repository.save(da);
	}
}
