package com.mutants.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutants.model.DnaSequence;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MutantDnaAnalyzerControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private String dnaAnalyzerUrl;
	private DnaSequence dnaSequence;
	private URI uri;
	private List<String> mutantDna;
	private List<String> humanDna;
	
	@BeforeEach
	public void before() throws URISyntaxException {
		dnaAnalyzerUrl = "http://localhost:" + port + "/mutant";
		uri = new URI(dnaAnalyzerUrl);
		dnaSequence = new DnaSequence();
		
		String[] dnaMutantStr = {"GGGgGA","CAGTGC","ataaGT","AGtatT","CCcCTA","TCACTG"};
		String[] dnaHumanStr = {"GGGaGA","CAGTGC","ataaGT","AGtatT","CCcCTA","TCACTG"};
		
		mutantDna = Arrays.asList(dnaMutantStr);
		humanDna = Arrays.asList(dnaHumanStr);
	}
	
	@Test
	public void shouldReturnHttpOk() {
		dnaSequence.setDna(mutantDna);
		HttpEntity<DnaSequence> request = new HttpEntity<>(dnaSequence);
		ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
		Assert.assertEquals(200, response.getStatusCodeValue());
	}

	
	@Test
	public void shouldReturnHttpForbidden() {
		dnaSequence.setDna(humanDna);
		HttpEntity<DnaSequence> request = new HttpEntity<>(dnaSequence);
		ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request, String.class);
		Assert.assertEquals(403, response.getStatusCodeValue());
	}
}
