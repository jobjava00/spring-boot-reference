package com.github.jobjava00.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jobjava00.json.JsonSample;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jobjava00
 */

public class JsonWithoutSpringTests {
	//autowired 하지 않고 사용
	JacksonTester<JsonSample> jsonTester;

	@Before
	public void setUp(){
		ObjectMapper objectMapper = new ObjectMapper();
		JacksonTester.initFields(this, objectMapper);
	}
	@Test
	public void testJson() throws IOException {
		JsonSample sample = new JsonSample();
		sample.setName("jobjava");
		sample.setNumber(100);

		JsonContent<JsonSample> jsonContent = jsonTester.write(sample);

		assertThat(jsonContent)
				.hasJsonPathStringValue("@.name")
				.extractingJsonPathStringValue("@.name").isEqualTo("jobjava");

		assertThat(jsonContent)
				.hasJsonPathNumberValue("@.number")
				.extractingJsonPathNumberValue("@.number").isEqualTo(100);

	}
}
