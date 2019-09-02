package com.autogeneral.exception;

import com.autogeneral.enums.TaskToDoEnum;

import java.util.List;

public class ValidationResponse {

	List<Detail> details;

	String name;



	public ValidationResponse(List<Detail> details) {
		this.details = details;
		this.name = TaskToDoEnum.VALIDATION_ERROR.value();
	}


	public ValidationResponse() {
	}

	public List<Detail> getDetails() {
		return details;
	}
	public String getName() {
		return name;
	}

	public void setDetail(List<Detail> details) {
		this.details = details;
	}



}
