package com.mutants.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mutants.service.DnaSequenceProcesor;
import com.mutants.util.Builder;
import com.mutants.util.DnaStringAnalyzer;

@Component
@Qualifier("vertical")
public class DnaVerticalSequenceProcessor implements DnaSequenceProcesor {
	
	private static final Logger logger = LoggerFactory.getLogger(DnaVerticalSequenceProcessor.class);
	
	/**
	 * Analyzes horizontal sequences
	 */
	@Override
	public int analyzeSequences(String[] dna, int nitroSeqValue) {
		
		StringBuilder sb;
		int dnaConsecSequences = 0;
		int n = dna.length;
		
		if(n > 0) {
			String[][] dnaArr = Builder.build2dArray(dna);
			
			for (int i = 0 ; i < n ; i++) {
				 sb = new StringBuilder();
			    for (int j = 0 ; j < n; j++) {
			    	sb.append(dnaArr[j][i]);
			    }
			    String dnaStr = sb.toString().toLowerCase();
			    dnaConsecSequences += DnaStringAnalyzer.analyzeSequence(dnaStr, nitroSeqValue);
			}
		}
		logger.info("Vertical occurrences: {}", dnaConsecSequences);
		return dnaConsecSequences;
	}
}
