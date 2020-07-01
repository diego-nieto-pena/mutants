package com.mutants.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.mutants.entity.StatsApi;
import com.mutants.entity.StatsResult;
import com.mutants.repository.StatsApiJpaRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StatsApiServiceImplTest {
	
	@Mock
	private StatsApiJpaRepository jpaRepository;
	
	@InjectMocks
	private StatsApiServiceImpl statsApiService;
	
	private static StatsApi entry;
	private static StatsApi entry2;
	private static StatsResult stats;
	
	private Gson gson = new Gson();
	
	@BeforeAll
	private static void init() {
		entry = new StatsApi(1,"", 2, true);
		entry2 = new StatsApi(2,"", 2, false);
		stats = new StatsResult(40, 60, roundUp(0.40));
	}
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findAll_ShouldReturnEmpty() {
	   Mockito.when(jpaRepository.findAll()).thenReturn(Arrays.asList());
	   assertThat(statsApiService.findAll().size(), is(0));
	   Mockito.verify(jpaRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void findAll_ShouldReturnEntries() {	
		Mockito.when(jpaRepository.findAll()).thenReturn(Arrays.asList(entry, entry2));
		assertThat(statsApiService.findAll().size(), is(2));
		assertThat(statsApiService.findAll().get(0), is(entry));
        assertThat(statsApiService.findAll().get(1),is(entry2));
		Mockito.verify(jpaRepository, Mockito.times(3)).findAll();
	}

	
	@Test
	public void testGetStatsApi() {
		Object[] objArr = {"40", "100"};
		Mockito.when(jpaRepository.statsQuery()).thenReturn(Arrays.asList(objArr, objArr));
		assertEquals(gson.toJson(statsApiService.getStats()),gson.toJson(stats));
	}
	
	private static double roundUp(double value) {
		BigDecimal bigD = BigDecimal.valueOf(value);
		bigD = bigD.setScale(2, RoundingMode.HALF_UP);
		
		return bigD.doubleValue();
	}
}
