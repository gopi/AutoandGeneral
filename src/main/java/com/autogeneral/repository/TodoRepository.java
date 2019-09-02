package com.autogeneral.repository;

import com.autogeneral.model.ToDoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends CrudRepository<ToDoItem, Long> {
}
