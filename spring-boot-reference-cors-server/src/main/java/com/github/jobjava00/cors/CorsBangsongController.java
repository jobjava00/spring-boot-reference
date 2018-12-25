package com.github.jobjava00.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jobjava00
 */
@RestController
public class CorsBangsongController {

	@CrossOrigin    //개별적으로 url 명시할 때 붙여줌
	@GetMapping("/cors/bs")
	public CorsBangsong bangsong() {
		CorsBangsong bangsong = new CorsBangsong();
		bangsong.setStreamerName("jobjava");
		bangsong.setTitle("Cors 테스트");
		return bangsong;
	}
}
