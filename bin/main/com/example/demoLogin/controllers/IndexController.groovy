package com.example.demoLogin.controllers

import com.example.demoLogin.entity.User
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

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
  ModelAndView testPost(@RequestParam Map data) {
		println("*"*100)
		println("hola")
		println (data)

		User user = new User(name, password)

    ModelAndView model = new ModelAndView("register");
		return model;
  }

}
