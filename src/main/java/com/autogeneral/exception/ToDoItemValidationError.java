package com.autogeneral.exception;

import com.autogeneral.enums.TaskToDoEnum;
import org.springframework.http.HttpStatus;

public class ToDoItemValidationError extends RuntimeException{

	Detail detail;
	String name;
	HttpStatus status;

	public ToDoItemValidationError(Detail detail, String message) {
		super(message);
		this.detail = detail;
		this.name = TaskToDoEnum.VALIDATION_ERROR.value();
		this.status = HttpStatus.BAD_REQUEST;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public Detail getDetail() {
		return detail;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
