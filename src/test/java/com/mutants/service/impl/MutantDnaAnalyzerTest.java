package com.mutants.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.mutants.conf.AnalyzerConfiguration;
import com.mutants.service.DnaSequenceProcesor;
import com.mutants.service.StatsApiService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MutantDnaAnalyzerTest {

	@Mock
	private DnaSequenceProcesor horizontalProcessor;
	
	@Mock
	private DnaSequenceProcesor verticalProcessor;
	
	@Mock
	private DnaSequenceProcesor obliqueProcessor;
	
	@Mock
	private AnalyzerConfiguration conf;
	
	@Mock
	private StatsApiService statsService;
	
	@InjectMocks
	private MutantDnaAnalyzerImpl analyzer;
	
	String[] dna = {"GGGaGA","CAGTGC","ataaGT","AGtatT","CCcCTA","TCACTG"};
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testIsHumanDna() {
		Mockito.when(conf.getNitroSequenceValue()).thenReturn(4);
		Mockito.when(conf.getConsecutiveNitroSequenceMinValue()).thenReturn(2);
		Mockito.when(horizontalProcessor.analyzeSequences(dna, 4)).thenReturn(1);
		Mockito.when(verticalProcessor.analyzeSequences(dna, 4)).thenReturn(0);
		Mockito.when(obliqueProcessor.analyzeSequences(dna, 4)).thenReturn(0);
		boolean isMutant = analyzer.isMutant(dna);
		assertEquals(false, isMutant);
	}
	
	@Test
	public void testIsMutantDna() {
		Mockito.when(conf.getNitroSequenceValue()).thenReturn(4);
		Mockito.when(conf.getConsecutiveNitroSequenceMinValue()).thenReturn(2);
		Mockito.when(horizontalProcessor.analyzeSequences(dna, 4)).thenReturn(1);
		Mockito.when(verticalProcessor.analyzeSequences(dna, 4)).thenReturn(1);
		Mockito.when(obliqueProcessor.analyzeSequences(dna, 4)).thenReturn(1);
		boolean isMutant = analyzer.isMutant(dna);
		assertEquals(true, isMutant);
	}
}
