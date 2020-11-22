package com.example.react.connect;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@RequestMapping("/hello")
	public String getName() {
		return "Hello Gopi";
	}
	

}
