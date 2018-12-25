package com.github.jobjava00.hateoas;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author jobjava00
 */
@Component
public class BangsongConverter implements Converter<String, Bangsong> {
	@Override public Bangsong convert(String id) {
		Bangsong bangsong = new Bangsong();
		bangsong.setId(Integer.parseInt(id));
		return bangsong;
	}
}
