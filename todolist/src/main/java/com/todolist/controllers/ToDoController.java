package com.todolist.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.dtos.ToDoPostDto;
import com.todolist.dtos.ToDoPutDto;
import com.todolist.models.ToDo;
import com.todolist.repositories.ToDoRepository;

@RestController
@RequestMapping("api/todos")
public class ToDoController {

//	@Autowired
	private final ToDoRepository toDoRepository;

	public ToDoController(ToDoRepository toDoRepository) {
		this.toDoRepository = toDoRepository;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ToDo AddToDo(@RequestBody ToDoPostDto todo) {
		var task = new ToDo(todo.getTask());
		return toDoRepository.save(task);
		
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<ToDo> GetList(){
		return toDoRepository.findByOrderByDateDesc();
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void DeleteTodo(@PathVariable("id")String id) {
		toDoRepository.deleteById(id);
	}
	
	@PutMapping("{id}")
	public ToDo UpdateToDo(@PathVariable("id")String id, @RequestBody ToDoPutDto todoUpdate) {
		
		var todo = toDoRepository.findById(id).get();
		todo.setTask(todoUpdate.getTask());
		return toDoRepository.save(todo);
	}
	
	@GetMapping("{id}")
	public ToDo GetTodo(@PathVariable("id")String id) {
		return toDoRepository.findById(id).orElse(null);
	}
	
	@DeleteMapping
	public void DeleteAll() {
		toDoRepository.deleteAll();
	}
}
