package com.github.jobjava00.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * @author jobjava00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class MockBeanTests {

	//전체 클래스를 mock으로 교체함
	@MockBean
	SampleService sampleService;

	@Autowired WebTestClient webTestClient;

	@Test
	public void testGetName() {
		given(sampleService.getName()).willReturn("Mock");
		webTestClient.get().uri("/test/remote").exchange()
				.expectStatus().isOk()
				.expectBody(String.class)
				.isEqualTo("Mock");
	}

	@Test
	public void testGetNumber(){
		assertThat(sampleService.getNumber()).isEqualTo(0).as("숫자 0인지 테스트");
	}
}
