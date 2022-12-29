package com.example.demoLogin

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class IndexController {

    @GetMapping("/")
    String showIndex(){
        return "index";
    }
}
