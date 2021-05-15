package com.imranmadbar.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "Welcome to Docker Spring Boot MySql App !";
	}
	
	@GetMapping("/home")
	public String appHome() {
		return "Message from Docker Spring Boot MySql App Home !";
	}
	
	

}
