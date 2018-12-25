package com.github.jobjava00;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class HsqlApplication {

	//in-memory 테스트
	public static void main(String[] args) {
		SpringApplication.run(HsqlApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(final JdbcTemplate jdbcTemplate) {
		return (args) -> {
			Integer count = jdbcTemplate.queryForObject("select count(*) from Customers", Integer.class);
			System.out.println("count: " + count);
		};
	}
}

