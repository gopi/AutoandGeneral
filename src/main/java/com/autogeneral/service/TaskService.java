package com.autogeneral.service;

import com.autogeneral.model.BalanceTestResult;
import com.autogeneral.exception.ToDoItemValidationError;

public interface  TaskService {
	BalanceTestResult validateBrackets(String input) throws ToDoItemValidationError;
}
