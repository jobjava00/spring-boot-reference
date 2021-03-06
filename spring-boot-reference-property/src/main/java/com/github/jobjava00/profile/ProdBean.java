package com.github.jobjava00.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author jobjava00
 */
@Component
@Profile("prod")
public class ProdBean implements MyBean {
	@Override public String getMessage() {
		return "prod";
	}
}
