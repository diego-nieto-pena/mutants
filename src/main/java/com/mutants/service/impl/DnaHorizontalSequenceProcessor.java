package com.mutants.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mutants.service.DnaSequenceProcesor;
import com.mutants.util.DnaStringAnalyzer;

@Component
@Qualifier("horizontal")
public class DnaHorizontalSequenceProcessor  implements DnaSequenceProcesor {

	@Override
	public int analyzeSequences(String[] dna, int nitroSeqValue) {
		int dnaConsecSequences = 0;
		
		for(int i=0; i < dna.length; i++) {
			String dnaStr = String.join("", dna[i]).toLowerCase();
			dnaConsecSequences += DnaStringAnalyzer.analyzeSequence(dnaStr, nitroSeqValue);
		}
		
		return dnaConsecSequences;
	}
}
