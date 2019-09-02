package com.autogeneral;

import com.autogeneral.model.BalanceTestResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskTests {

    private static final Logger LOG = LoggerFactory.getLogger(TaskTests.class);
    @Autowired
	private TestRestTemplate restTemplate;

    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

    @Test
	public void ValidateBalancedBracketsOne() {

		String brackets = "({[]})";
        LOG.info("ValidateBalancedBracketsOne" + brackets);

        StringBuilder urlBuilder = new StringBuilder("/test/1.0/tasks/validateBrackets/?input=");
        urlBuilder.append(encodeValue(brackets));
        LOG.info("Encoded URL : " + urlBuilder.toString());


		// when
		ResponseEntity<BalanceTestResult> balanceTestResult = restTemplate.getForEntity(urlBuilder.toString(), BalanceTestResult.class);

		// then
		assertThat(balanceTestResult.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(balanceTestResult.getBody().getIsBalanced().equals(true));
	}

    @Test
    public void ValidateBalancedBracketsTwo() {

        String brackets = "{{{({[]})}}}";
        LOG.info("ValidateBalancedBracketsTwo" + brackets);

        StringBuilder urlBuilder = new StringBuilder("/test/1.0/tasks/validateBrackets/?input=");
        urlBuilder.append(encodeValue(brackets));
        LOG.info("Encoded URL : " + urlBuilder.toString());


        // when
        ResponseEntity<BalanceTestResult> balanceTestResult = restTemplate.getForEntity(urlBuilder.toString(), BalanceTestResult.class);

        // then
        assertThat(balanceTestResult.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(balanceTestResult.getBody().getIsBalanced().equals(true));
    }

    @Test
    public void ValidateImBalancedBracketsone() {

        String brackets = "{[}]";
        LOG.info("ValidateImBalancedBracketsTwo" + brackets);

        StringBuilder urlBuilder = new StringBuilder("/test/1.0/tasks/validateBrackets/?input=");
        urlBuilder.append(encodeValue(brackets));
        LOG.info("Encoded URL : " + urlBuilder.toString());


        // when
        ResponseEntity<BalanceTestResult> balanceTestResult = restTemplate.getForEntity(urlBuilder.toString(), BalanceTestResult.class);

        // then
        assertThat(balanceTestResult.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void ValidateImBalancedBracketsTwo() {

        String brackets = "[{)]";
        LOG.info("ValidateImBalancedBracketsone" + brackets);

        StringBuilder urlBuilder = new StringBuilder("/test/1.0/tasks/validateBrackets/?input=");
        urlBuilder.append(brackets);
        LOG.info("Encoded URL : " + urlBuilder.toString());


        // when
        ResponseEntity<BalanceTestResult> balanceTestResult = restTemplate.getForEntity(urlBuilder.toString(), BalanceTestResult.class);

        // then
        assertThat(balanceTestResult.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(balanceTestResult.getBody().getIsBalanced().equals(false));
    }
}
