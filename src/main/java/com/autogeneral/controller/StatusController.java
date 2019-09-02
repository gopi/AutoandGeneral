package com.autogeneral.controller;

import com.autogeneral.exception.ToDoItemNotFoundError;
import com.autogeneral.exception.ToDoItemValidationError;
import com.autogeneral.model.StatusResponse;
import com.autogeneral.model.ToDoItem;
import com.autogeneral.service.StatusService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/1.0/status")
public class StatusController {

	StatusService statusService;

	@Autowired
	public StatusController(StatusService statusService) {
		this.statusService = statusService;
	}

	/**
	 *
	 * The status API checks the load average of the system if the load < 60.00 then return "healthy" else "unhealthy"
	 *
	 *
	 * @return   a ResponseEntity or a StatusResponse as JSON objects
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value = "Return system's status")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = StatusResponse.class)})
	public ResponseEntity<StatusResponse> getSystemStatus() {
		StatusResponse statusResponse = statusService.getSystemStatus();
		  return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
	}
}
