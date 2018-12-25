package com.github.jobjava00.test;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author jobjava00
 */
@Service
public class RestTemplateService {
	RestTemplate restTemplate;

	//생성자 한개만 있을 경우 빈으로 주입 자동으로 해줌
	public RestTemplateService(RestTemplateBuilder builder){
		this.restTemplate = builder.build();
	}

	public String getName(){
		return restTemplate.getForObject("/test/foo", String.class);
	}
}
