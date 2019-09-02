package com.autogeneral.enums;

public enum TaskToDoEnum {

	VALIDATION_ERROR("ToDoItemValidationError"),
	NOT_FOUND("NotFoundError");

	String value;

	TaskToDoEnum(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
