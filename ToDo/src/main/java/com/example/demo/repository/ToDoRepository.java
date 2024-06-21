package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
	List<ToDo> findByCategoryId(Integer categoryId);
	List<ToDo> findByCategoryIdAndCheckId(Integer categoryId, Integer checkId);
}
