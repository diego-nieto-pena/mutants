package com.mutants.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StatsControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private String dnaAnalyzerUrl;
	private URI uri;
	
	@BeforeEach
	public void before() throws URISyntaxException {
		dnaAnalyzerUrl = "http://localhost:" + port + "/stats";
		uri = new URI(dnaAnalyzerUrl);
	}
	
	@Test
	public void shouldReturnHttpOk() {
		ResponseEntity<String> response = this.restTemplate.getForEntity(uri, String.class);
		Assert.assertEquals(200, response.getStatusCodeValue());
	}
	
}
