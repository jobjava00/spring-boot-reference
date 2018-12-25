package com.github.jobjava00;

import com.github.jobjava00.hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WelcomeApplication {

	@Autowired HelloService helloService;

	@RequestMapping("/")
	String home() {
		return helloService.getMessage();
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(WelcomeApplication.class);
		application.addListeners(new MyListener());
		application.run(args);
		//SpringApplication.run(WelcomeApplication.class, args);
	}
}

