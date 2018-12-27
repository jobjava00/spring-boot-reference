package com.github.jobjava00.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

/**
 * @author jobjava00
 */
@Component
@Endpoint(id = "my")
public class MyEndpoint {
	private String value = "hello world";

	@ReadOperation
	public String getValue() {
		return value;
	}

	@WriteOperation
	public void setValue(String value) {
		this.value = value;
	}

	@DeleteOperation
	public void deleteValue() {
		this.value = "hello world";
	}
}
