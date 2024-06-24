package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class checkController {

	@PostMapping("/todo/{categoryId}/{todoId}/check")
	public String check(
			@PathVariable("categoryId") Integer categoryId,
			@PathVariable("todoId") Integer todoId,
			@RequestParam("name")String name) {
		return "redirect:/todo/{categoryId}";
	}
}
