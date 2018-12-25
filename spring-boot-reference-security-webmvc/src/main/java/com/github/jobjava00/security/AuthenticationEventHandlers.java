package com.github.jobjava00.security;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

/**
 * @author jobjava00
 */
@Component
public class AuthenticationEventHandlers {
	@EventListener
	public void handleBadCredential(AuthenticationFailureBadCredentialsEvent event) {
		System.out.println(event.getAuthentication().getPrincipal() + " 인증 시도중...");
		System.out.println("비번이 틀렸습니다.");
	}
}
