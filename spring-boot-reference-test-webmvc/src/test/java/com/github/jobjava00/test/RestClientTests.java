package com.github.jobjava00.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author jobjava00
 */
@RunWith(SpringRunner.class)
@RestClientTest(RestTemplateService.class)
public class RestClientTests {
	@Autowired
	RestTemplateService restTemplateService;

	//가상으로 서버 띄워서 테스트 해줌.. 외부 api 시 좋을 듯
	@Autowired MockRestServiceServer server;

	@Test
	public void fooTest(){
		server.expect(requestTo("/test/foo"))
				.andRespond(withSuccess("hello", MediaType.TEXT_PLAIN));

		String name = restTemplateService.getName();
		assertThat(name).isEqualTo("hello");
	}
}
