package com.github.jobjava00;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author jobjava00
 */
public class MyListener implements ApplicationListener<ApplicationStartedEvent> {
	@Override public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println("APPLICATION IS STATED");
	}
}
