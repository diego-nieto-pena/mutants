package com.mutants.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AnalyzerConfiguration {

	@Value("${nitro.sequence.value}")
	private int nitroSequenceValue;
	
	@Value("${consecutive.nitro.sequence.min.value}")
	private int consecutiveNitroSequenceMinValue;
	
	@Value("${allowed.nitro.base}")
	private String allowedNitroBase;
	
	@Value("${invalid.dna.sequence.msg}")
	private String invalidDnaSequenceMsg;
	
	@Value("${invalid.dna.structure.msg}")
	private String invalidDnaStructureMsg;
	
	@Value("${dna.array.length}")
	private int dnaArrayLength;
	
	public int getNitroSequenceValue() {
		return nitroSequenceValue;
	}
	public int getConsecutiveNitroSequenceMinValue() {
		return consecutiveNitroSequenceMinValue;
	}
		public String getAllowedNitroBase() {
		return allowedNitroBase;
	}
	public String getInvalidDnaSequenceMsg() {
		return invalidDnaSequenceMsg;
	}
	public String getInvalidDnaStructureMsg() {
		return invalidDnaStructureMsg;
	}
	public int getDnaArrayLength() {
		return dnaArrayLength;
	}
}
