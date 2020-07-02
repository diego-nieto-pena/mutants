package com.mutants.entity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.mutants.entity.StatsApi;
import com.mutants.repository.StatsApiJpaRepository;
import com.mutants.service.impl.StatsApiServiceImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StatsApiTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Mock
	private StatsApi statsApi;
	
	@Mock
	private StatsApiJpaRepository repository;
	
	@InjectMocks
	private StatsApiServiceImpl statsApiService;
	
	private static final String MUTANT_DNA_SEQUENCE = "GGGGtGAGgTaCtaaGtTGtattTCCcctT";
	private static final String HUMAN_DNA_SEQUENCE = "GGGGtGAGgTaCtaaGtTGtattTCCcctT";
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		statsApi = new StatsApi(MUTANT_DNA_SEQUENCE, 4, true);
	}
	
	@Test
	public void saveStatsApi() {
		when(repository.save(any())).thenReturn(statsApi);
		when(statsApi.getDnaSequence()).thenReturn(MUTANT_DNA_SEQUENCE);
		
		StatsApi output = statsApiService.save(HUMAN_DNA_SEQUENCE, 4, true);
		assertEquals(output.getDnaSequence(), MUTANT_DNA_SEQUENCE);
	}
	
	@Test
	public void dnaSequenceAlreadyRegisteredTest() {
		when(repository.save(any())).thenReturn(statsApi);
		when(statsApi.getDnaSequence()).thenReturn(MUTANT_DNA_SEQUENCE);
		
		StatsApi output = statsApiService.save(MUTANT_DNA_SEQUENCE, 4, true);
		assertEquals(output.getDnaSequence(), MUTANT_DNA_SEQUENCE);
	}
}
