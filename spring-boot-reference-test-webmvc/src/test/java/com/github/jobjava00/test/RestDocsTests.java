package com.github.jobjava00.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author jobjava00
 */
@RunWith(SpringRunner.class)
@WebMvcTest //service, dao 는 bean 등록 안해줌.
@AutoConfigureRestDocs      //spring-rest-docs 만들어짐 위치 : target/generated-snippets, document() 해줘야 함
public class RestDocsTests {

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

	@Test
	public void testSpringDocs() throws Exception {
		given(sampleService.getName()).willReturn("jobjava");

		mockMvc.perform(get("/test/remote"))
				.andExpect(status().isOk())
				.andExpect(content().string("jobjava"))
				.andDo(document("/test/remote"));   //명시적으로 document 만들어 주는법
	}

	@TestConfiguration  //클래스 내에 지정 시 해당 test 클래스에서만 적용
	static class ResultHandlerConfiguration {
		//빈으로 등록 해서 모든 응답에 document 만들어 주는 방법
		@Bean
		public RestDocumentationResultHandler restDocumentation() { // 따로 document() 안해줘도 모든 테스트 메소드에 rest docs 만들어줌
			return MockMvcRestDocumentation.document("{method-name}");
		}
	}
}
