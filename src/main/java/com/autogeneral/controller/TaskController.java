package com.autogeneral.controller;

import com.autogeneral.model.BalanceTestResult;
import com.autogeneral.exception.ToDoItemValidationError;
import com.autogeneral.service.TaskService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;

@RestController
@RequestMapping("/test/1.0/tasks")
public class TaskController {

	TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	/**
	 *
	 * The validateBrackets take the String input and verifies the bracket are in equal pair or not
	 *
	 * @param input - a string of between 1 and 50 characters
	 * @return   either a ResponseEntity or a ValidationResponse as JSON objects
	 * @throws ToDoItemValidationError
	 */
	@RequestMapping(value="/validateBrackets", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Checks if brackets in a string are balanced",
			 notes = "Brackets in a string are considered to be balanced if the following criteria are met:\n" +
			"        - For every opening bracket (i.e., **`(`**, **`{`**, or **`[`**), there is a matching closing bracket (i.e., **`)`**, **`}`**, or **`]`**) of the same type (i.e., **`(`** matches **`)`**, **`{`** matches **`}`**, and **`[`** matches **`]`**). An opening bracket must appear before (to the left of) its matching closing bracket. For example, **`]{}[`** is not balanced.\n" +
			"        - No unmatched braces lie between some pair of matched bracket. For example, **`({[]})`** is balanced, but **`{[}]`** and **`[{)]`** are not balanced.",
			response = BalanceTestResult.class)
	@ApiParam(name = "input", value = "Input string (max length 100)", required = true, type = "String")
	@Size(min=1,max=100)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = BalanceTestResult.class),
			@ApiResponse(code = 400, message = "Validation error", response = ToDoItemValidationError.class) })
	public ResponseEntity<BalanceTestResult> validateBrackets(@RequestParam(value = "input", defaultValue = "") String input) throws ToDoItemValidationError {
		   BalanceTestResult balanceTestResult = taskService.validateBrackets(input) ;
		  return new ResponseEntity<BalanceTestResult>(balanceTestResult, HttpStatus.OK);
	}
}
