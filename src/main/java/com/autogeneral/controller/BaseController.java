package com.autogeneral.controller;

import com.autogeneral.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/1.0/")
public class BaseController {

	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<ExceptionResponse> show() throws Exception{
		    ExceptionResponse exceptionResponse = new ExceptionResponse();
		    exceptionResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
		    exceptionResponse.setErrorMessage("Auto General Assignment , Please check valid end points");
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
