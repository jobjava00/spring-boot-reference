package com.github.jobjava00.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jobjava00
 */
@RestController
public class UserController {

	@GetMapping("/user")
	public User currentUser() {
		User user = new User();
		user.setAge(20);
		user.setName("jobjava");
		user.setHeight(200);
		return user;
	}
}
