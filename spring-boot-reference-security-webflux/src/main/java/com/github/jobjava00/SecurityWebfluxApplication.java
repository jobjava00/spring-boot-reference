package com.github.jobjava00;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@SpringBootApplication
public class SecurityWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityWebfluxApplication.class, args);
	}

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		return http
				.authorizeExchange()
				.matchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.pathMatchers("/hello.html").permitAll()
				.anyExchange().authenticated().and()
				.formLogin().and()
				.build();
	}
}

