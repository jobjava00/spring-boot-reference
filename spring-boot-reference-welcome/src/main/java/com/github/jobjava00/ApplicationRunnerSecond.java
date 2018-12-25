package com.github.jobjava00;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jobjava00
 */
@Component
@Order(1)
public class ApplicationRunnerSecond implements ApplicationRunner {
	@Override public void run(ApplicationArguments args) throws Exception {
		System.out.println("second runner");
	}
}
