package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/category/{categoryId}/edit")
	public String edit(
			@PathVariable("categoryId") Integer categoryId,
			Model model) {
		Category category = categoryRepository.findById(categoryId).get();
		model.addAttribute("category", category);

		return "category/editCategory";
	}

	@PostMapping("/category/{categoryId}/edit")
	public String update(@PathVariable("categoryId") Integer categoryId,
			@RequestParam("newName") String newName) {
		Category category = categoryRepository.findById(categoryId).get();
		category.setCategoryName(newName);
		categoryRepository.save(category);
		
		
		return "redirect:/category";
	}

	@PostMapping("/category/{categoryId}/delete")
	public String delete(
			@PathVariable("categoryId") Integer categoryId) {
		categoryRepository.deleteById(categoryId);
		return "redirect:/category";
	}

	@GetMapping("/back")
	public String back() {
		return "redirect:/category";
	}
}
