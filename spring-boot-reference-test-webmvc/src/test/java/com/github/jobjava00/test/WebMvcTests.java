package com.github.jobjava00.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author jobjava00
 */
@RunWith(SpringRunner.class)
@WebMvcTest //service, dao 는 bean 등록 안해줌.
public class WebMvcTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	SampleService sampleService;

	@Test
	public void testRemote() throws Exception {
		given(sampleService.getName()).willReturn("jobjava");

		mockMvc.perform(get("/test/remote"))
				.andExpect(handler().handlerType(SampleController.class))
				.andExpect(handler().methodName("remote"))
				.andExpect(status().isOk())
				.andExpect(content().string("jobjava"));
	}
}
