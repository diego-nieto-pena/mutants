package com.mutants.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mutants.conf.AnalyzerConfiguration;
import com.mutants.exception.BadDnaSequenceException;
import com.mutants.model.DnaSequence;
import com.mutants.service.MutantDnaAnalyzer;

@RestController
public class MutantDnaAnalyzerController {

	private Logger logger = LoggerFactory.getLogger(MutantDnaAnalyzerController.class);
	
	@Autowired
	private MutantDnaAnalyzer analyzer;
	
	@Autowired
	private AnalyzerConfiguration conf;
	
	/**
	 * 
	 * @param dnaSequence
	 * @return
	 */
	@PostMapping(path="/mutant")
	public ResponseEntity<Object> analyze(@RequestBody DnaSequence dnaSequence) {
		
		logger.info("Starting mutant DNA detector for {} ...", dnaSequence.getDna());
		
		List<String> dnaList = dnaSequence.getDna();
		String dnaString = String.join("", dnaList);
		
		if(!validDnaSequence(dnaString)) {
			throw new BadDnaSequenceException(conf.getInvalidDnaSequenceMsg());
		}
		
		String[] dna = new String[dnaList.size()];
		dna = dnaList.toArray(dna);
				
		if(analyzer.isMutant(dna)) {
			logger.info("Mutant DNA found!");
			return new ResponseEntity<Object>(HttpStatus.OK);
		} 
		logger.info("Just another human...");
		return new ResponseEntity<Object>(HttpStatus.FORBIDDEN);
	}
	
	private boolean validDnaSequence(String dna) {
		Pattern pattern = Pattern.compile(conf.getAllowedNitroBase(), Pattern.CASE_INSENSITIVE);
		if (!pattern.matcher(dna).matches()) {
			return false;
		}
		return true;
	}
}
