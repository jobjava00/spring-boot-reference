package com.github.jobjava00.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jobjava00
 */
@Service
public class HelloService {
	@Autowired ApplicationArguments arguments;

	public String getMessage() {
		List<String> collect = arguments.getOptionValues("hello");
		return collect.stream().collect(Collectors.joining());
	}

	@PostConstruct
	public void init() {
		System.out.println("================HelloService init===============");
	}
}
