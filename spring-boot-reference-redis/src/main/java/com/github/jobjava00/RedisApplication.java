package com.github.jobjava00;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication {

	// docker run -p 6379:6379 --name redis -d redis
	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

}

