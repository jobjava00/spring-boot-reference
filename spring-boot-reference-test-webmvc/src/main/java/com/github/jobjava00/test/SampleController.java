package com.github.jobjava00.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jobjava00
 */
@RestController
@RequestMapping("/test")
public class SampleController {

	@Autowired
	SampleService sampleService;

	@GetMapping("/foo")
	public String foo() {
		return "Hello";
	}

	@GetMapping("/remote")
	public String remote() {
		return sampleService.getName();
	}
}
