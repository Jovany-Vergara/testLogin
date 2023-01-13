package com.example.demoLogin.controllers

import com.example.demoLogin.entity.User
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity
import com.example.demoLogin.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import com.example.demoLogin.service.UserService
import org.springframework.web.server.ResponseStatusException

@Controller
class IndexController {

  @Autowired
  UserRepository userRepository
	@Autowired
  UserService userService

	@GetMapping("/")
	ModelAndView index() {
    ModelAndView model = new ModelAndView("home");
		return model;
	}

	@GetMapping("/register")
	ModelAndView register() {
    ModelAndView model = new ModelAndView("register");
		model.addObject("isCreated", true)
		return model;
	}

	@PostMapping("/testPost")
  @ResponseBody
  ModelAndView testPost(@RequestParam Map data) {
		println("*"*100)
		println("hola")
		println(data)
		User user = new User(name: data.username, password: data.password)
		Boolean isCreated = userService.createUser(user);
		println(isCreated)
		if(isCreated) {
    	ModelAndView model = new ModelAndView("consulta");
			List<Map> users = userRepository.findAll()
			model.addObject("users", users)
			return model;
		}
    ModelAndView model = new ModelAndView("register");
		model.addObject("isCreated", isCreated)
		return model;
  }

	@GetMapping("/consulta")
	ModelAndView consulta(){
		ModelAndView model = new ModelAndView("consulta");
		List<Map> users = userRepository.findAll()
		model.addObject("users", users)
		return model
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

 	@PostMapping("/delete")
 	String deleteById(@RequestParam("name") String name) {
		println "Hola: delete ${name}"
		userService.deleteUser(name)

		ModelAndView model = new ModelAndView("consulta");
		List<Map> users = userRepository.findAll()
		model.addObject("users", users)
		return model
 	}

	@GetMapping("/login")
	ModelAndView login(){
    ModelAndView model = new ModelAndView("login");
		return model
	}

	@PostMapping("/login")
	ModelAndView login_in(){
		println "Hola mundo"
    ModelAndView model = new ModelAndView("login");
		return model
	}
}
