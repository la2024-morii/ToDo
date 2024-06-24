package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Controller
public class AddCategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/category/add")
	public String create() {
		return "category/addCategory";
	}
	
	@PostMapping("/category/add")
	public String store(
			@RequestParam("newCategoryWord") String newCategoryWord,
			Model model) {
		Category category = new Category(newCategoryWord);
		categoryRepository.save(category);

		return "redirect:/todo/{categolyId}";
	}
}
