package com.github.jobjava00;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongodbApplication {

	// docker run -p 27017:27017 --name mongo -d mongo
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}
}

