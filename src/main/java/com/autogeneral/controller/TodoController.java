package com.autogeneral.controller;

import com.autogeneral.exception.ToDoItemNotFoundError;
import com.autogeneral.model.BalanceTestResult;
import com.autogeneral.model.ToDoItem;
import com.autogeneral.exception.ToDoItemValidationError;
import com.autogeneral.model.ToDoItemAddRequest;
import com.autogeneral.model.ToDoItemUpdateRequest;
import com.autogeneral.service.TodoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;

@RestController
@RequestMapping("/test/1.0/todo")
public class TodoController {

	TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@RequestMapping(method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create a to do item")
	@ApiParam(name = "body", required = true)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ToDoItem.class),
			@ApiResponse(code = 400, message = "Validation error", response = ToDoItemValidationError.class) })
	public ResponseEntity<ToDoItem> create(@RequestBody ToDoItemAddRequest toDoItemAddRequest) throws ToDoItemValidationError {
		ToDoItem newItem = new ToDoItem();
		newItem.setText(toDoItemAddRequest.getText());
		ToDoItem returnItem = todoService.createItem(newItem);
		return new ResponseEntity<ToDoItem>(returnItem, HttpStatus.OK);
	}


	@RequestMapping(value="/{id}",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve a specific item by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ToDoItem.class),
			@ApiResponse(code = 400, message = "Validation error", response = ToDoItemValidationError.class),
			@ApiResponse(code = 404, message = "Not Found Error", response = ToDoItemNotFoundError.class)})
	public ResponseEntity<ToDoItem> show(@PathVariable(value = "id") Long id) throws ToDoItemValidationError {
		ToDoItem item = todoService.fetchItem(id) ;
		return new ResponseEntity<ToDoItem>(item, HttpStatus.OK);
	}


	@RequestMapping(value="/{id}", method=RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Modify an item")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ToDoItem.class),
			@ApiResponse(code = 400, message = "Validation error", response = ToDoItemValidationError.class),
			@ApiResponse(code = 404, message = "Not Found Error", response = ToDoItemNotFoundError.class)})
	public ResponseEntity<ToDoItem> update(@PathVariable(value = "id") Long id, @RequestBody ToDoItemUpdateRequest toDoItemUpdateRequest) throws ToDoItemValidationError {
		ToDoItem returnItem = todoService.updateItem(id, toDoItemUpdateRequest) ;
		return new ResponseEntity<ToDoItem>(returnItem, HttpStatus.OK);
	}


}
