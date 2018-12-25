package com.github.jobjava00;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

/**
 * @author jobjava00
 */
public class WebControllerTests {
	@Test
	public void helloTest() {
		//Given
		WebController webController = new WebController();
		Model model = new ExtendedModelMap();

		//When
		webController.hello(model, "jobjava");

		//Then
		model.asMap().forEach((k, v) -> System.out.println("key: " + k + " value : " + v));
	}
}
