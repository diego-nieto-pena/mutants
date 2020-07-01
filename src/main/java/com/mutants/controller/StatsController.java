package com.mutants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mutants.entity.StatsResult;
import com.mutants.service.StatsApiService;

/**
 * @author diego.nieto
 *
 */
@RestController
public class StatsController {

	@Autowired
	private StatsApiService statsService;
	
	private Gson gson = new Gson();
	
	/**
	 * Gets the detector statistics
	 * @return
	 */
	@GetMapping(path="/stats")
	public ResponseEntity<String> getAPIStats() {
		StatsResult stats = statsService.getStats();
		
		if(stats != null) {
			return new ResponseEntity<String>(gson.toJson(stats), HttpStatus.OK);
		}
		
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
