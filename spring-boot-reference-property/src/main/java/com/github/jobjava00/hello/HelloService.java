package com.github.jobjava00.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jobjava00
 */
@Service
public class HelloService {
	@Autowired
	JobJavaProperties jobjavaProperties;

	public String getMessage() {
		return jobjavaProperties.getName() + " " + jobjavaProperties.getList().size();
	}
}
