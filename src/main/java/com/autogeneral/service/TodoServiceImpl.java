package com.autogeneral.service;

import com.autogeneral.exception.ToDoItemNotFoundError;
import com.autogeneral.model.ToDoItem;
import com.autogeneral.model.ToDoItemAddRequest;
import com.autogeneral.model.ToDoItemUpdateRequest;
import com.autogeneral.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

	private static final Logger LOG = LoggerFactory.getLogger(TodoServiceImpl.class);

	@Autowired
	private TodoRepository todoRepository;
	private ValidationService validationService;

	@Autowired
	public TodoServiceImpl(TodoRepository todoRepository, ValidationService validationService) {
		this.todoRepository = todoRepository;
		this.validationService = validationService;
	}

	@Override
	public ToDoItem createItem(ToDoItem newItem) {

		LOG.debug("ToDoItem : " + newItem.toString());
		Boolean isInputValid = validationService.validateText(newItem.getText());
		if (isInputValid == Boolean.FALSE) {
			throw validationService.buildValidationError(newItem.getText(), "text");
		} else {
			newItem.setText(newItem.getText());
			newItem.setIsCompleted(Boolean.FALSE);
			newItem.setCreatedAt(LocalDateTime.now());
			return todoRepository.save(newItem);
		}
	}

	@Override
	public ToDoItem fetchItem(Long id) {

		LOG.debug("ToDoItem ID: " + id.toString());

		Optional<ToDoItem> todo = todoRepository.findById(id);
		if (todo == null) {
			String message = "Item with " + id + " not found";
			throw new ToDoItemNotFoundError(message);
		}
		return todo.get();
	}

	/**
	 * Give the option to only update part of the item
	 * @param id
	 * @param newDetails
	 * @return  the updated item
	 */
	@Override
	public ToDoItem updateItem(Long id, ToDoItemUpdateRequest newDetails) {

		LOG.debug("ToDoItem ID: " + id.toString());
		LOG.debug("ToDoItemUpdateRequest: " + newDetails.toString());

		ToDoItem toDoItem = this.fetchItem(id);
		if (newDetails != null) {
			if (newDetails.getIsCompleted() != null) {
				Boolean isInputValid = validationService.validateIsComplete(newDetails.getIsCompleted());
				toDoItem.setIsCompleted(newDetails.getIsCompleted());
			}
			if (newDetails.getText() != null) {
				Boolean isInputValid = validationService.validateText(newDetails.getText());
				if (isInputValid == Boolean.FALSE) {
					throw validationService.buildValidationError(newDetails.getText(), "text");
				}
				toDoItem.setText(newDetails.getText());
			}
			todoRepository.save(toDoItem);
		}
		return toDoItem;
	}




}
