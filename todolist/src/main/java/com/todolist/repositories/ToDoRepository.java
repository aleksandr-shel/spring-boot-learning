package com.todolist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todolist.models.ToDo;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, String> {
	List<ToDo> findByOrderByDateDesc();
}
