package com.github.jobjava00;

import com.github.jobjava00.user.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WelcomeApplicationTests {

	@Autowired UserService userService;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(userService);
		Assert.assertNotNull(userService.getUserRepository());
	}
}

