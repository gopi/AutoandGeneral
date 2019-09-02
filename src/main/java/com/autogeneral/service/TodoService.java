package com.autogeneral.service;

import com.autogeneral.model.ToDoItem;
import com.autogeneral.model.ToDoItemAddRequest;
import com.autogeneral.model.ToDoItemUpdateRequest;

public interface TodoService {
	ToDoItem createItem(ToDoItem input);

	ToDoItem fetchItem(Long input);

	ToDoItem updateItem(Long id, ToDoItemUpdateRequest newDetails);
}
