package com.github.jobjava00.hateoas;

import com.github.jobjava00.exception.BangsongException;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author jobjava00
 */
@RestController
public class BangsongController {

	@GetMapping("/bs/{id}")
	public BangsongResource getBangsong(@PathVariable("id") Bangsong bangsong) {
		if (bangsong.getId() == 100) {
			throw new BangsongException();
		}

		BangsongResource resource = new BangsongResource();
		resource.setTitle(bangsong.getId() + "번째 방송");
		Link link = linkTo(BangsongController.class).slash("bs").slash(bangsong.getId()).withSelfRel();
		Link listLink = linkTo(BangsongController.class).slash("bs").withRel("bangsongList");
		resource.add(link, listLink);

		return resource;
	}
}
