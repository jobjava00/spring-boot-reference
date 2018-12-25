package com.github.jobjava00.book;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * @author jobjava00
 */
@JsonComponent
public class BookMapper {
	// custom JSON serializer
	public static class BookSerializer extends JsonSerializer<Book> {
		@Override public void serialize(Book book, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
			jsonGenerator.writeStartObject();
			//추가한 값만 넘김
			jsonGenerator.writeStringField("title", book.getTitle());
			jsonGenerator.writeEndObject();
		}
	}
}
