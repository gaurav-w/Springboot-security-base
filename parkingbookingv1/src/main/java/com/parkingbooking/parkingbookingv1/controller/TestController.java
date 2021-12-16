package com.parkingbooking.parkingbookingv1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("user")
	public String user() {
		return "hello hi this is test page for USER role";
	}
	
	@GetMapping("admin")
	public String admin() {
		return "hello hi this is test page for ADMIN role";
	}
}
