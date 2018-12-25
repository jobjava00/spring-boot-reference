package com.github.jobjava00.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author jobjava00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Import(TestConfig.class)
public class MockMvcTests {
	@Autowired MockMvc mockMvc;
	@Autowired String myBean;
	@Test
	public void testFoo() throws Exception{
		assertThat(myBean).isNotNull();
		assertThat(mockMvc).isNotNull();

		mockMvc.perform(get("/test/foo"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello"))
				.andDo(print());
	}
}
