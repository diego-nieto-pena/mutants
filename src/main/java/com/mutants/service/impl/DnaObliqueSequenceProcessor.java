package com.mutants.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mutants.service.DnaSequenceProcesor;
import com.mutants.util.Builder;
import com.mutants.util.DnaStringAnalyzer;

@Component
@Qualifier("oblique")
public class DnaObliqueSequenceProcessor implements DnaSequenceProcesor {
	
	private static final Logger logger = LoggerFactory.getLogger(DnaObliqueSequenceProcessor.class);

	/**
	 * Analyzes obliques sequences
	 */
	@Override
	public int analyzeSequences(String[] dna, int nitroSeqValue) {
		
		StringBuilder sb;
		int dnaConsecSequences = 0;
		
		String[][] dnaArr = Builder.build2dArray(dna);
		
		int n = dnaArr.length;
		
		if(n > 0) {
			for( int k = 0 ; k < n * 2 ; k++ ) {
				sb = new StringBuilder();
		        for( int j = 0 ; j <= k ; j++ ) {
		            int i = k - j;
		            if( i < n && j < n ) {
		                sb.append(dnaArr[i][j]);
		            }
		        }
		        String dnaStr = sb.toString().toLowerCase();
		        dnaConsecSequences += DnaStringAnalyzer.analyzeSequence(dnaStr, nitroSeqValue);
		    }	
		}
		
		logger.info("Oblique occurrences: {}", dnaConsecSequences);
		return dnaConsecSequences;
	}
	
}
