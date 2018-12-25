package com.github.jobjava00.test;

import com.github.jobjava00.json.JsonSample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jobjava00
 */
@RunWith(SpringRunner.class)
@JsonTest
public class JsonTests {
	//spring 기본 json parser 인 jackson 사용
	@Autowired JacksonTester<JsonSample> jsonTester;

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
