package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/category")
	public String index(Model model) {
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);
		return "category/category";
	}

	@GetMapping("/category/add")
	public String create() {
		return "category/addCategory";
	}

	@PostMapping("/category/add")
	public String store(
			@RequestParam("newCategoryWord") String newCategoryWord,
			Model model
			) {
		Category category =new Category(newCategoryWord);
		categoryRepository.save(category);
		
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
