package com.github.jobjava00.hateoas;

import org.springframework.hateoas.ResourceSupport;

/**
 * @author jobjava00
 */
public class BangsongResource extends ResourceSupport {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
