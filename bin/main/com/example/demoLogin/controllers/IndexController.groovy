package com.example.demoLogin.controllers

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.PostMapping

@Controller
class IndexController {

	@GetMapping("/")
	ModelAndView index() {
    ModelAndView model = new ModelAndView("home");
		return model;
	}

	@GetMapping("/register")
	ModelAndView register() {
    ModelAndView model = new ModelAndView("register");
		return model;
	}

	@PostMapping("/testPost")
    @ResponseBody
    String testPost() {
			print("hola llegue")
        return "has hecho una peticion post";
    }

}
