package com.github.jobjava00.endpoints;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * @author jobjava00
 */
@Component
public class MyInfoContributor implements InfoContributor {
	@Override public void contribute(Info.Builder builder) {
		builder.withDetail("myInfo", "jobjava00").build();
	}
}
