package com.github.jobjava00.book;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @author jobjava00
 */
@Component
public class BookFilter implements WebFilter {
	@Override public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		System.out.println("Book Filter");
		return chain.filter(exchange);
	}
}
