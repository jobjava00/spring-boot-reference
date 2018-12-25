package com.github.jobjava00.test;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author jobjava00
 */
@TestConfiguration
public class TestConfig {
	@Bean
	public String myBean(){
		return "myBean";
	}
}
