package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "todo_id")
	private Integer todoId;
	
	@Column(name = "todo_name")
	private String name;
	
	@Column(name = "category_id")
	private Integer categoryId;
	
	@Column(name = "check_id")
	private Integer checkId;
	
	public ToDo() {
		
	}

	public ToDo(String name, Integer categoryId, Integer checkId) {
		super();
		this.name = name;
		this.categoryId = categoryId;
		this.checkId = checkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCheckId() {
		return checkId;
	}

	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}

	public Integer getTodoId() {
		return todoId;
	}
	
	

}
