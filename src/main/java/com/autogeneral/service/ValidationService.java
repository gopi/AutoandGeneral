package com.autogeneral.service;

import com.autogeneral.exception.ToDoItemValidationError;

public interface ValidationService {

	ToDoItemValidationError buildValidationError(String input, String text);

	Boolean validateText(String input);

	Boolean checkBrackets(String input);

	Boolean validateIsComplete(Boolean isCompleted);
}
