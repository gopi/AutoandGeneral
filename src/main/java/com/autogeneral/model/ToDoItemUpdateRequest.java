package com.autogeneral.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;

public class ToDoItemUpdateRequest{

    Long id;
    String text;
    Boolean isCompleted;

    @JsonCreator
    public ToDoItemUpdateRequest (Long id, @JsonProperty("name") String text, Boolean isCompleted) {

        this.id = id;
        this.text = text;
        this.isCompleted = isCompleted;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean completed) {
        isCompleted = completed;
    }

}
