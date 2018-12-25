package com.github.jobjava00.json;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jobjava00
 */
@RestController
public class JsonController {
	@PostMapping("/json")
	public JsonUser mapping(@RequestBody JsonUser jsonUser){
		return jsonUser;
	}
}
