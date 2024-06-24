package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.ToDo;
import com.example.demo.repository.ToDoRepository;

@Controller
@RequestMapping("/todo")
public class ToDoController {
	@Autowired
	ToDoRepository toDoRepository;
	
	//[GET]"/todo/{categoryId}/"
	//index()
	//toDo.html
	@GetMapping("/{categoryId}")
	public String index(
			@PathVariable("categoryId") Integer categoryId,
			Model model) {
		List<ToDo> todoList = this.toDoRepository.findByCategoryId(categoryId);
		for(int i = 0; i < todoList.size(); i++) {
			System.out.println(todoList.get(i).getName());
		}
		model.addAttribute("todoList", todoList);
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
			@PathVariable("todoId")Integer todoId,
			Model model) {
		
		ToDo todo = this.toDoRepository.findById(todoId).get();
		model.addAttribute("todo", todo);
		return "todo/editToDo";
	}

	//[POST]"/todo/{categoryId}/{todoId}/edit"
	//	update()
	@PostMapping("/{categoryId}/{todoId}/edit")
	public String update(
			@PathVariable("categoryId")Integer categoryId,
			@PathVariable("todoId")Integer todoId,
			@RequestParam("name")String name) {
			ToDo todo = this.toDoRepository.findById(todoId).get();
			todo.setName(name);
			this.toDoRepository.save(todo);
		
		return "redirect:/todo/{categoryId}";

	}

	//[POST]"/todo/{categoryId}/{todoId}/delete"
	//	delete()
	@PostMapping("/{categoryId}/{todoId}/delete")
	public String delete(
			@PathVariable("categoryId")Integer categoryId,
			@PathVariable("todoId")Integer todoId) {
		
		this.toDoRepository.deleteById(todoId);
		return "redirect:/todo/{categoryId}";
	}
	//[GET]"/todo/{categoryId}/complete"
	//	complrte()
	//completeToDo.html
	@GetMapping("/{categoryId}/complete")
	public String complete(
			@PathVariable("categoryId")Integer categoryId
//			@RequestParam("categoryName")String categoryName,
//			@RequestParam("name") String name,
//			@RequestParam("todoId")Integer todoId
			) {
		return "todo/completeToDo";
	}

}
