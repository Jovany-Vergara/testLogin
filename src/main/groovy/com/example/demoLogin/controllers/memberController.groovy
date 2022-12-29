package com.example.demoLogin

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class memberController {

    @GetMapping("/login")
    String showLoginForm(){
        return "templates/loginForm";
    }

    @GetMapping("/register")
    String registerForm(Model model){
        return "templates/registerForm";
    }
}
