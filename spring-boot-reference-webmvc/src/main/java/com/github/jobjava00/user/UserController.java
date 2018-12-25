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
	@Autowired HttpMessageConverters converters;

	/**
	 * "main" -> ViewResolver* -> View* -> ContentNegotiatingViewResolver -> View
	 * 뷰 리졸버에서 뷰가 여러개 찾아지더라도 ContentNegotiatingViewResolver 에서 최종적으로 판단한다.
	 *
	 * @return
	 */
	@GetMapping("/")
	public String index() {
		System.out.println("=======================================================");
		converters.getConverters().forEach(c -> System.out.println(":::::::::::::::::::::"+c.getClass()));
		return "Hello Spring MVC";
	}

	@GetMapping("/user")
	public User currentUser() {
		User user = new User();
		user.setAge(20);
		user.setName("jobjava");
		user.setHeight(200);
		return user;
	}
}
