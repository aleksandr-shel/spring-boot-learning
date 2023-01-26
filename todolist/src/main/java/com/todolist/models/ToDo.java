package com.todolist.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ToDo {
	@Id
	private String id;
	
	@Column
	private String task;
	
	@Column
	private Date date;

	
	
	public ToDo() {
		super();
		this.id = UUID.randomUUID().toString();
		this.date = new Date();
	}



	public ToDo(String task) {
		super();
		this.id = UUID.randomUUID().toString();
		this.task = task;
		this.date = new Date();
	}


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getTask() {
		return task;
	}



	public void setTask(String task) {
		this.task = task;
	}



	public String getDate() {
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z"); 
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss a"); 
		return dateFormat.format(this.date);
	}



	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
