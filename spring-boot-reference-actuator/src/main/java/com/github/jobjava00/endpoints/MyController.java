package com.github.jobjava00.endpoints;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author jobjava00
 */
@RestController
public class MyController {

	@GetMapping("/api/list")
	@Timed(value = "api.list")  // http://localhost:8081/management/metrics 로 확인 가능
	public List<String> apiList() {
		return Arrays.asList("test1", "Test2");
	}
}