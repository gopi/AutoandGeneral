package com.autogeneral;

import com.autogeneral.model.StatusResponse;
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
public class StatusTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getSytemStatus_withHealthy() {

		// when
		ResponseEntity<StatusResponse> statusResponse = restTemplate.getForEntity("/test/1.0/status", StatusResponse.class);

		// then
		assertThat(statusResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(statusResponse.getBody().equals(new StatusResponse("healthy")));
	}

	@Test
	public void getSytemStatus_withUnhealthy() {

		// when
		ResponseEntity<StatusResponse> statusResponse = restTemplate.getForEntity("/test/1.0/status", StatusResponse.class);

		// then
		assertThat(statusResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(statusResponse.getBody().equals(new StatusResponse("unhealthy")));
	}
}
