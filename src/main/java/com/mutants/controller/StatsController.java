package com.mutants.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {

	@GetMapping(path="/stats")
	public void getAPIStats() {
		
	}
}
