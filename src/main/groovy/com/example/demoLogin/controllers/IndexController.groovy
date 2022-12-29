package com.example.demoLogin.Controllers

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class IndexController {

	@GetMapping("/")
	public String index() {
		return "home";
	}

}
