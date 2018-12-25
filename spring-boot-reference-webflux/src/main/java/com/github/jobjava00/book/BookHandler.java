package com.github.jobjava00.book;

import com.github.jobjava00.book.Book;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author jobjava00
 */
@Controller
public class BookHandler {
	public Mono<ServerResponse> allBooks(ServerRequest request) {
		Book book1 = new Book();
		book1.setIsbn("1123");
		book1.setTitle("[ALL] Boot Spring Boot");

		Book book2 = new Book();
		book2.setIsbn("2222");
		book2.setTitle("[ALL] Boot Spring Framework 5");

		Flux<Book> books = Flux.just(book1, book2);

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(books, Book.class);
	}

	public Mono<ServerResponse> book(ServerRequest request) {
		Book book = new Book();
		book.setIsbn("1123");
		book.setTitle("[BOOK] Boot Spring Boot");

		Mono<Book> mono = Mono.just(book);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(mono, Book.class);
	}
}
