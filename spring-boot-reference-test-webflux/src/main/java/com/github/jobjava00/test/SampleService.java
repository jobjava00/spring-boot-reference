package com.github.jobjava00.test;

import org.springframework.stereotype.Service;

/**
 * @author jobjava00
 */
@Service
public class SampleService {
	public String getName() {
		return "Remote Service";
	}

	public int getNumber() {
		return 100;
	}
}
