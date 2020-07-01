package com.mutants.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StatsApiTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private StatsApi stats;
	private String dna;
	
	@BeforeEach
	public void setUp() {
		dna = "GGGaGACAGTGCataaGTAGtatTCCcCTATCACTG";
		stats = new StatsApi(dna, 4, true);
	}
	
	/*@Test
	public void saveStatsApi() {
		StatsApi actual = entityManager.persist(stats);
		assertThat(actual.getDnaSequence()).isEqualTo(dna);
	}*/
}
