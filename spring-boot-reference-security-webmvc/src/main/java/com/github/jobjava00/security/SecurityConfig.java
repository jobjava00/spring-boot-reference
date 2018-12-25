package com.github.jobjava00.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author jobjava00
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.antMatchers("/hello.html").permitAll()
				.requestMatchers(new AntPathRequestMatcher("/hello.html")).permitAll()
				.anyRequest().fullyAuthenticated()
				.and()
				.formLogin().permitAll()
				.and()
				.logout().permitAll();
	}

	//h2 연동을 위해 csrf 끔 https://www.slipp.net/questions/546
	/*@Override protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/h2-console*//*").permitAll()
				.and()
				.csrf().disable()
				.headers().frameOptions().disable();  //X-Frame-Options HTTP 응답 헤더는 해당 페이지를 <frame> 또는<iframe>, <object> 에서 렌더링할 수 있는지 여부를 나타내는데 사용
	}*/
}
