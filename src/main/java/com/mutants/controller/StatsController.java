package com.mutants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutants.entity.StatsResult;
import com.mutants.service.StatsApiService;

@RestController
public class StatsController {

	@Autowired
	private StatsApiService statsService;
	
	@GetMapping(path="/stats")
	public ResponseEntity<StatsResult> getAPIStats() {
		StatsResult stats = statsService.getStats();
		
		if(stats != null) {
			return new ResponseEntity<StatsResult>(stats, HttpStatus.OK);
		}
		
		return new ResponseEntity<StatsResult>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
