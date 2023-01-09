package com.example.demoLogin.controllers

import com.example.demoLogin.entity.User
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import com.example.demoLogin.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired

@Controller
class IndexController {

  @Autowired
  UserRepository userRepository

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
		println(data)
		Boolean isExisted = true;
		if(!isExisted){
			User user = new User(name: data.username, password: data.password)
			userRepository.save(user)
		}

    ModelAndView model = new ModelAndView("register");
		model.addObject("isExisted", isExisted)
		return model;
  }

	@GetMapping("/findAll")
  @ResponseBody
	ModelAndView findAllUsers(){
		println("*" * 100)
		println("Aqui estan tus usuarios")
		List<Map> users = userRepository.findAll()
		println(users.dump());
    ModelAndView model = new ModelAndView("register");
		model.addObject("users", users)
		return model
	}

}
