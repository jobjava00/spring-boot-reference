package com.github.jobjava00.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jobjava00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRestTemplateTests {

	@Autowired TestRestTemplate testRestTemplate;

	@Test
	public void testFoo(){
		String result = testRestTemplate.getForObject("/test/foo", String.class);
		assertThat(result).isEqualTo("Hello");
	}
}
