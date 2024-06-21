package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
	@GetMapping("/category")
	public String index() {
		return "category/category";
	}

	@GetMapping("/category/add")
	public String create() {
		return "category/addCategory";
	}

	@PostMapping("/category/add")
	public String store() {
		return "redirect:/todo/{categolyId}";
	}

	@GetMapping("/category/{categoryId}/edit")
	public String edit() {
		return "editCategory";
	}

	@PostMapping("/category/{categoryId}/edit")
	public String update() {
		return "redirect:/todo/{categoryId}";
	}
@PostMapping("/category/{categoryId}/delete")
	public String delete() {
		return "redirect:/category";
	}

	@GetMapping("/back")
	public String back() {
		return "redirect:/category";
	}
}
