package com.mutants.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mutants.conf.AnalyzerConfiguration;
import com.mutants.service.DnaSequenceProcesor;
import com.mutants.service.MutantDnaAnalyzer;
import com.mutants.service.StatsApiService;

@Service
public class MutantDnaAnalyzerImpl implements MutantDnaAnalyzer {

	@Autowired
	@Qualifier("horizontal")
	private DnaSequenceProcesor horizontalProcessor;
	
	@Autowired
	@Qualifier("vertical")
	private DnaSequenceProcesor verticalProcessor;
	
	@Autowired
	@Qualifier("oblique")
	private DnaSequenceProcesor obliqueProcessor;
	
	@Autowired
	private StatsApiService statsService;

	@Autowired
	private AnalyzerConfiguration conf;
	
	@Override
	public boolean isMutant(String[] dna) {
		boolean result = false;
		
		String dnaSequence = String.join(",", dna);
		
		int nitroSeqValue = conf.getNitroSequenceValue();
		
		int hOccurrences = horizontalProcessor.analyzeSequences(dna, nitroSeqValue);
		int vOccurrences = verticalProcessor.analyzeSequences(dna, nitroSeqValue);
		int obOccurrences = obliqueProcessor.analyzeSequences(dna, nitroSeqValue);
		
		int total = hOccurrences + vOccurrences + obOccurrences;
		
		if(total >= conf.getConsecutiveNitroSequenceMinValue()) {
			result = true;
		}
		
		statsService.save(dnaSequence, total, result);
		
		return result;
	}

}
