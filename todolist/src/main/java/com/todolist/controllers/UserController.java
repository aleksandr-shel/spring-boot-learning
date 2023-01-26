package com.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.todolist.repositories.UserRepository;

@Controller
@RequestMapping("api/user")
public class UserController {
	@Autowired
    private UserRepository userRepo;
	
	@PostMapping("login")
	@ResponseStatus(HttpStatus.OK)
	public void Login() {
		
	}
	
	@PostMapping("register")
	@ResponseStatus(HttpStatus.OK)
	public void Register() {
		
	}
}
