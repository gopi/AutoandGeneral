package com.autogeneral.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class ToDoItem {

	@Id
	@GeneratedValue
	Long id;

	String text;

	Boolean isCompleted;

	@JsonFormat(
			shape = JsonFormat.Shape.STRING)
	LocalDateTime createdAt;

	public ToDoItem(String text) {
		this.text = text;
		this.isCompleted = false;
		this.createdAt = LocalDateTime.now();
	}

	public ToDoItem() {
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean completed) {
		isCompleted = completed;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


}
