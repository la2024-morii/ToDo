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
			@PathVariable("categoryId") Integer categoryId) {
		return "todo/toDo";
	}

	//[POST]"/{categoryId}/{toDoId}/check"
	//check()
	//redirect/:todo/{caregoryId}
	@PostMapping("/{categoryId}/{toDoId}/check")
	public String check(
			@PathVariable("categoryId") Integer categoryId,
			@PathVariable("toDoId") Integer toDoId) {
		return "redirect:/{categoryId}";
	}

	@GetMapping("/{categoryId}/add")
	public String create() {
		return "todo/addToDo";
	}

	@PostMapping("/{categoryId}/add")
	public String store() {
		return "redirect:/{categoryId}";
	}

	//[GET]"/todo/{categoryId}/{toDoId}/edit"
	//	edit()
	//editToDo.html
	@GetMapping("/{categoryId}/{toDoID}/edit")
	public String edit() {
		return "todo/editToDo";
	}

	//[POST]"/todo/{categoryId}/{toDoId}/edit"
	//	update()
	@PostMapping("/{categoryId}/{toDoId}/edit")
	public String update() {
		return "redirect:/{categoryId}";

	}

	//[POST]"/todo/{categoryId}/{toDoId}/delete"
	//	delete()
	@PostMapping("/{categoryId}/{toDoId}/delete")
	public String delete() {
		return "redirect:/{categoryId}";
	}
	//[GET]"/todo/{categoryId}/complete"
	//	complrte()
	//completeToDo.html
	@GetMapping("/{categoryId}/complete")
	public String complete() {
		return "todo/completeToDo";
	}

}
