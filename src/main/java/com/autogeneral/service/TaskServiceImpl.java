package com.autogeneral.service;

import com.autogeneral.model.BalanceTestResult;
import com.autogeneral.exception.ToDoItemValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

	private static final Logger LOG = LoggerFactory.getLogger(TaskServiceImpl.class);

	private ValidationService validationService;

	@Autowired
	public TaskServiceImpl(ValidationService validationService) {
		this.validationService = validationService;
	}

	@Override
	public BalanceTestResult validateBrackets(String input) throws ToDoItemValidationError {

		BalanceTestResult response = new BalanceTestResult();

		LOG.debug("Input - " + input);
		Boolean isInputValid = validationService.validateText(input);
		if (isInputValid == Boolean.FALSE) {
			throw validationService.buildValidationError(input, "input");
		} else {
			response.setInput(input);
			response.setIsBalanced(validationService.checkBrackets(input));
		}
		return response;
	}





}
