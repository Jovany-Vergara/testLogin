package com.example.demoLogin.controllers

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView

@Controller
class IndexController {

	@GetMapping("/")
	ModelAndView index() {
    ModelAndView model = new ModelAndView("home");
		return model;
	}

}
