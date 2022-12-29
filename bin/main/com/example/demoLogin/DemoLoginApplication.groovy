package com.example.demoLogin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration

@SpringBootApplication(exclude = [SecurityAutoConfiguration.class ])
class DemoLoginApplication {

	static void main(String[] args) {
		SpringApplication.run(DemoLoginApplication, args)
	}

}
