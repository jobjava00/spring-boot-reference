package com.github.jobjava00;

import com.github.jobjava00.rest.GithubCommit;
import com.github.jobjava00.rest.GithubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@SpringBootApplication
public class RestApplication {

	@Autowired RestTemplateBuilder restTemplateBuilder;

	@Autowired WebClient.Builder webClientBuilder;

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@Bean
	@Order(1)
	public ApplicationRunner restTemplateApplicationRunner() {
		return args -> {
			StopWatch stopWatch = new StopWatch();
			stopWatch.start();

			RestTemplate restTemplate = restTemplateBuilder.build();
			GithubRepository[] result = restTemplate.getForObject("https://api.github.com/users/jobjava00/repos", GithubRepository[].class);
			Arrays.stream(result).forEach(r -> System.out.println("restTemplate repos: " + r.getUrl()));

			GithubCommit[] commits = restTemplate.getForObject("https://api.github.com/repos/jobjava00/spring-boot-reference/commits", GithubCommit[].class);
			Arrays.stream(commits).forEach(c -> System.out.println("restTemplate commits: " + c.getSha()));

			stopWatch.stop();
			System.out.println(stopWatch.prettyPrint());
		};
	}

	@Bean
	@Order(2)
	public ApplicationRunner webClientMonoApplicationRunner() {
		return args -> {
			StopWatch stopWatch = new StopWatch();
			stopWatch.start();

			WebClient webClient = webClientBuilder.baseUrl("https://api.github.com").build();
			Mono<GithubRepository[]> repos = webClient.get().uri("/users/jobjava00/repos")
					.retrieve()
					.bodyToMono(GithubRepository[].class);

			Mono<GithubCommit[]> commits = webClient.get().uri("/repos/jobjava00/spring-boot-reference/commits")
					.retrieve()
					.bodyToMono(GithubCommit[].class);

			repos.doOnSuccess(ra -> {
				Arrays.stream(ra).forEach(r -> System.out.println("webClient mono repos: " + r.getUrl()));
			}).subscribe();
			commits.doOnSuccess(ca -> {
				Arrays.stream(ca).forEach(c -> System.out.println("webClient mono commits: " + c.getSha()));
			}).subscribe();

			stopWatch.stop();
			System.out.println(stopWatch.prettyPrint());
		};
	}


	@Bean
	@Order(3)
	public ApplicationRunner webClientFluxApplicationRunner() {
		return args -> {
			StopWatch stopWatch = new StopWatch();
			stopWatch.start();

			WebClient webClient = webClientBuilder.baseUrl("https://api.github.com").build();
			Flux<GithubRepository> repos = webClient.get().uri("/users/jobjava00/repos")
					.retrieve()
					.bodyToFlux(GithubRepository.class);

			Flux<GithubCommit> commits = webClient.get().uri("/repos/jobjava00/spring-boot-reference/commits")
					.retrieve()
					.bodyToFlux(GithubCommit.class);

			//한건한건 subscribe 로 보내고 stream 흐르게 해줌
			repos.subscribe(r -> System.out.println("webClient flux repos : " + r.getUrl()));

			/*repos.doOnNext(r -> System.out.println("webClient flux repos : " + r.getUrl()))
					.subscribe();*/

			commits.doOnNext(c -> System.out.println("webClient flux commits : " + c.getSha()))
					.subscribe();

			stopWatch.stop();
			System.out.println(stopWatch.prettyPrint());
		};
	}
}

