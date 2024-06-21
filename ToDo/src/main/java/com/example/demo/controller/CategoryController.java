package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
	@GetMapping("/category")
	public String index() {
		return "category";
	}

	@GetMapping("/category/add")
	public String create() {
		return "addCategory";
	}

	public String store() {
		return "index";
	}
	@GetMapping("/category/{categoryId}/edit")
	public String edit() {
		return "editCategory";
	}

	public String update() {
		return "index";
	}

	public String delete() {
		return "index";
	}

	@GetMapping("/back")
	public String back() {
		return "redirect:/category";
	}
}
