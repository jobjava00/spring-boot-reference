package com.github.jobjava00;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jobjava00
 */
@Component
@Order(0)
public class ApplicationRunnerFirst implements ApplicationRunner {
	@Override public void run(ApplicationArguments args) throws Exception {
		System.out.println("first runner");
	}
}
