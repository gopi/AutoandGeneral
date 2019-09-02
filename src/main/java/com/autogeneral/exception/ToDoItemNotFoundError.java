package com.autogeneral.exception;

import com.autogeneral.enums.TaskToDoEnum;

import java.util.List;

public class ToDoItemNotFoundError extends RuntimeException{

	List<Message> details;

	String name;



	public ToDoItemNotFoundError(List<Message> details) {
		this.details = details;
		this.name = TaskToDoEnum.NOT_FOUND.value();
	}


	public ToDoItemNotFoundError(String message) {
		super(message);
	}

	public List<Message> getDetails() {
		return details;
	}
	public String getName() {
		return name;
	}

	public void setDetail(List<Message> details) {
		this.details = details;
	}



}
