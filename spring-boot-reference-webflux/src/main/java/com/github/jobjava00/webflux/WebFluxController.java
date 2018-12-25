package com.github.jobjava00.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author jobjava00
 */
@RestController
@RequestMapping("/webflux")
public class WebFluxController {

	@GetMapping("/foo")
	public String getFoo() {
		return "jobjava";
	}

	// flux 는 0 ~ n 개
	@GetMapping("/flux")
	public Flux<String> flux() {
		return Flux.just("a", "b", "c");
	}

	// mono 는 0 ~ 1 개
	@GetMapping("/mono")
	public Mono<String> mono() {
		return Mono.just("mono");
	}
}
