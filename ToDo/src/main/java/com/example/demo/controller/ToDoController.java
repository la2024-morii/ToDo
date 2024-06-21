package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class ToDoController {
	//[GET]"/todo/{categoryId}/"
	//index()
	//toDo.html
	@GetMapping("/{categolyId}")
	public String index(
			@PathVariable("categoryId")Integer categoryId) {
		return "toDo";
	}
	
	//[POST]"/{categoryId}/{toDoId}/check"
	//check()
	//redirect/:todo/{caregoryId}
	@PostMapping("/{categoryId}/{toDoId}/check")
	public String check(
			@PathVariable("categoryId")Integer categoryId,
			@PathVariable("toDoId")Integer toDoId) {
		return "redirect/:{categoryId}";
	}
	

}
