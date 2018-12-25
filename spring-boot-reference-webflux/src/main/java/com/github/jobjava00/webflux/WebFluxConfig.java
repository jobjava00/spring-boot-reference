package com.github.jobjava00.webflux;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import java.util.concurrent.TimeUnit;

/**
 * @author jobjava00
 */
@Configuration
public class WebFluxConfig implements WebFluxConfigurer {
	@Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 100초간 캐쉬
		registry.addResourceHandler("/my/**")
				.addResourceLocations("classpath:/my/")
				.setCacheControl(CacheControl.maxAge(100, TimeUnit.SECONDS));
	}
}
