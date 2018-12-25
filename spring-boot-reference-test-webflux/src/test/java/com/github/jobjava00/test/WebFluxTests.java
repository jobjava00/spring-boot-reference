package com.github.jobjava00.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.BDDMockito.given;

/**
 * @author jobjava00
 */
@RunWith(SpringRunner.class)
@WebFluxTest
public class WebFluxTests {

	@Autowired
	WebTestClient webTestClient;

	@MockBean
	SampleService sampleService;

	@Test
	public void testRemote() throws Exception {
		given(sampleService.getName()).willReturn("jobjava");

		webTestClient.get().uri("/test/remote").exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo("jobjava");
	}
}
