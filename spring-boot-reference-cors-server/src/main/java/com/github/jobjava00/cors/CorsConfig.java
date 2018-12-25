package com.github.jobjava00.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jobjava00
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer{
	@Override public void addCorsMappings(CorsRegistry registry) {
		//여러개 한번에 적용할 때 패턴 적용함
		registry.addMapping("/cors/**").allowedOrigins("*");
	}
}
