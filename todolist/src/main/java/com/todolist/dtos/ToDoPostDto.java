package com.todolist.dtos;

public class ToDoPostDto {

	private String task;

	
	public ToDoPostDto() {
		
	}

	public ToDoPostDto(String task) {
		super();
		this.task = task;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	
}
