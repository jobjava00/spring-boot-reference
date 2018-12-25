package com.github.jobjava00;

import com.github.jobjava00.book.Book;
import com.github.jobjava00.book.BookHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class WebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);
	}

	@Autowired BookHandler bookHandler;

	@Bean
	public RouterFunction<ServerResponse> router() {
		return route(GET("/books").and(accept(APPLICATION_JSON)),
				req -> {
					System.out.println("handling /books");
					//handler 사용하지 않고 직접 리턴하는 방법
					Book book1 = new Book();
					book1.setIsbn("1123");
					book1.setTitle("[BOOKS] Boot Spring Boot");

					Book book2 = new Book();
					book2.setIsbn("2222");
					book2.setTitle("[BOOKS] Boot Spring Framework 5");

					Flux<Book> books = Flux.just(book1, book2);

					return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(books, Book.class);
				})
				.andRoute(GET("/all-books").and(accept(APPLICATION_JSON)), bookHandler::allBooks)
				.andRoute(GET("/book").and(accept(APPLICATION_JSON)), bookHandler::book);
	}
}

