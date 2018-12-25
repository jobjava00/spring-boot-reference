package com.github.jobjava00;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jobjava00
 */
@Controller
public class WebController {
	/**
	 * ViewName(String) --> ViewResolver --> View(View)
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("${index.path}")
	public String hello(Model model, @RequestParam(defaultValue = "jobjava") String name) {
		model.addAttribute("name", name);
		return "freemarker";
	}

	@GetMapping("/thymeleaf")
	public String thymeleaf(Model model, @RequestParam(defaultValue = "jobjava") String name) {
		model.addAttribute("name", name);
		return "thymeleaf";
	}
}
