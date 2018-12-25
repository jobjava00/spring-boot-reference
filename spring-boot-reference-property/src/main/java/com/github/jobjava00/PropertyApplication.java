package com.github.jobjava00;

import com.github.jobjava00.hello.HelloService;
import com.github.jobjava00.hello.JobJavaProperties;
import com.github.jobjava00.profile.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PropertyApplication {
	@Autowired HelloService helloService;

	@Autowired MyBean myBean;

	@Autowired Environment environment;

	@Bean
	@ConfigurationProperties("jobjava") //외부 라이브러리 프로퍼티 사용할 때 유용
	@Validated  //Bean 생성 시 validated 해줌
	public JobJavaProperties jobJavaProperties(){
		return new JobJavaProperties();
	}
	
	@RequestMapping("/")
	String home() {
		System.out.println(jobJavaProperties().getList().size());
		System.out.println(jobJavaProperties().getWorkFor());
		System.out.println(jobJavaProperties().getWhereToGo());
		System.out.println(jobJavaProperties().getNumber());
		System.out.println(jobJavaProperties().getNumber2());
		System.out.println(jobJavaProperties().getTime1());
		System.out.println(jobJavaProperties().getTime2());
		System.out.println(jobJavaProperties().getTime3());
		System.out.println(myBean.getMessage());
		System.out.println(environment.getProperty("jobjava.name"));
		return helloService.getMessage();
	}

	public static void main(String[] args) {
		SpringApplication.run(PropertyApplication.class, args);
	}
}

