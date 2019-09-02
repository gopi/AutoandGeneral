package com.autogeneral;

import com.autogeneral.model.ToDoItem;
import com.autogeneral.model.ToDoItemAddRequest;
import com.autogeneral.model.ToDoItemUpdateRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void addTodoItem_withValidText() {

		// when
		ResponseEntity<ToDoItem> todoItemResponse = restTemplate.postForEntity("/test/1.0/todo",
				new ToDoItemAddRequest("Auto General assignment"), ToDoItem.class);

		// then
		assertThat(todoItemResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

	}


    @Test
    public void addTodoItem_withInValidText() {

        // when
        ResponseEntity<ToDoItem> todoItemResponse = restTemplate.postForEntity("/test/1.0/todo",
                new ToDoItemAddRequest("Auto General assignment Auto General assignment Auto General assignment Auto General assignment"), ToDoItem.class);

        // then
        assertThat(todoItemResponse.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

    }

	@Test
	public void retrieveTodoItem_withValidText() {

		// add the text
		ResponseEntity<ToDoItem> todoItemResponse = restTemplate.postForEntity("/test/1.0/todo",
				new ToDoItemAddRequest("Auto General assignment second text"), ToDoItem.class);

		// then
		assertThat(todoItemResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

		// retrieve the value
		todoItemResponse = restTemplate.getForEntity("/test/1.0/todo/2", ToDoItem.class);

		// then
		assertThat(todoItemResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(todoItemResponse.getBody().getId().equals(2));
		assertThat(todoItemResponse.getBody().getIsCompleted().equals(false));
		assertThat(todoItemResponse.getBody().getText().equals("Auto General assignment second text"));
	}

	@Test
	public void updateTodoItem_withValidText() {

		Long id = 1L;
		// update the text
		ResponseEntity<ToDoItem> todoItemResponse = restTemplate.postForEntity("/test/1.0/todo",
				new ToDoItemUpdateRequest(id,"Auto General assignment updated text", true), ToDoItem.class);

		// then
		assertThat(todoItemResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

		// retrieve the value
		todoItemResponse = restTemplate.getForEntity("/test/1.0/todo/1", ToDoItem.class);

		// then
		assertThat(todoItemResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(todoItemResponse.getBody().getId().equals(1));
		assertThat(todoItemResponse.getBody().getIsCompleted().equals(true));
		assertThat(todoItemResponse.getBody().getText().equals("Auto General assignment updated text"));
	}
}
