package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class ToDoController {
	//[GET]"/todo/{categoryId}/"
	//index()
	//toDo.html
	@GetMapping("/{categolyId}")
	public String index(
			@PathVariable("categoryId") Integer categoryId,
			@RequestParam("categoryName")String categoryName,
			@RequestParam("name")String name,
			@RequestParam("todoId")Integer todoId) {
		return "todo/toDo";
	}

	//[POST]"/{categoryId}/{todoId}/check"
	//check()
	//redirect/:todo/{caregoryId}
	@PostMapping("/{categoryId}/{todoId}/check")
	public String check(
			@PathVariable("categoryId") Integer categoryId,
			@PathVariable("todoId") Integer todoId,
			@RequestParam("categoryName")String categoryName,
			@RequestParam("name")String name) {
		return "redirect:/{categoryId}";
	}

	@GetMapping("/{categoryId}/add")
	public String create(
			@PathVariable("categoryId")Integer categoryId
			) {
		return "todo/addToDo";
	}

	@PostMapping("/{categoryId}/add")
	public String store(
			@PathVariable("categoryId")Integer categoryId,
			@RequestParam("categoryName")String categoryName,
			@RequestParam("name")String name) {
		return "redirect:/{categoryId}";
	}

	//[GET]"/todo/{categoryId}/{todoId}/edit"
	//	edit()
	//editToDo.html
	@GetMapping("/{categoryId}/{todoId}/edit")
	public String edit(
			@PathVariable("categoryId")Integer categoryId,
			@PathVariable("todoId")Integer todoId) {
		return "todo/editToDo";
	}

	//[POST]"/todo/{categoryId}/{todoId}/edit"
	//	update()
	@PostMapping("/{categoryId}/{todoId}/edit")
	public String update(
			@PathVariable("categoryId")Integer categoryId,
			@PathVariable("todoId")Integer todoId,
			@RequestParam("categoryName")String categoryName,
			@RequestParam("name")String name) {
		return "redirect:/{categoryId}";

	}

	//[POST]"/todo/{categoryId}/{todoId}/delete"
	//	delete()
	@PostMapping("/{categoryId}/{todoId}/delete")
	public String delete(
			@PathVariable("categoryId")Integer categoryId,
			@PathVariable("todoId")Integer todoId) {
		return "redirect:/{categoryId}";
	}
	//[GET]"/todo/{categoryId}/complete"
	//	complrte()
	//completeToDo.html
	@GetMapping("/{categoryId}/complete")
	public String complete(
			@PathVariable("categoryId")Integer categoryId,
			@RequestParam("categoryName")String categoryName,
			@RequestParam("name") String name,
			@RequestParam("todoId")Integer todoId) {
		return "todo/completeToDo";
	}

}