package com.mutants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mutants.controller.MutantDnaAnalyzerController;
import com.mutants.controller.StatsController;

@SpringBootTest
class MutantsApplicationTests {
	
	@Autowired
	private MutantDnaAnalyzerController dnaController;
	
	@Autowired
	private StatsController statsController;

	@Test
	void contextLoads() throws Exception {
		assertThat(dnaController).isNotNull();
		assertThat(statsController).isNotNull();
	}
}
