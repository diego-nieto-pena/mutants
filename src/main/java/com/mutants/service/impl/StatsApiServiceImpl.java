package com.mutants.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutants.entity.StatsApi;
import com.mutants.entity.StatsResult;
import com.mutants.repository.StatsApiJpaRepository;
import com.mutants.service.StatsApiService;

@Service
public class StatsApiServiceImpl implements StatsApiService {

	private static final Logger logger = LoggerFactory.getLogger(StatsApiServiceImpl.class);
	
	@Autowired
	private StatsApiJpaRepository jpaRepository;
	
	/**
	 * DNA validation entry persistence
	 * 
	 * @param dnaSequence
	 * @param mutantStrings
	 * @param isMutant
	 */
	@Override
	public StatsApi save(String dnaSequence, int mutantStrings, boolean isMutant) {
		
		StatsApi statsApi = jpaRepository.findByDnaSequence(dnaSequence);
		
		if(statsApi != null) {
			return new StatsApi();
		}
		
		StatsApi newEntry = new StatsApi(dnaSequence, mutantStrings, isMutant);
		return jpaRepository.save(newEntry);
	}

	/**
	 * Returns the Detector Statistics
	 */
	@Override
	public StatsResult getStats() {
		
		StatsResult stats = null;
		
		List<Object[]> statsQuery = jpaRepository.statsQuery();
		
		if(statsQuery != null && statsQuery.size() > 0) {
			for(Object[] obj : statsQuery) {
				int total = Integer.parseInt(obj[1].toString());
				int mutant = Integer.parseInt(obj[0].toString());
				double ratio = (double) mutant / total;
				
				logger.info("Total Entries {} - Mutant DNA Entries {} Ratio {}", total, mutant, ratio);
				
				stats = new StatsResult();
				stats.setCountMutantDna(mutant);
				stats.setCountHumanDna(total - mutant);
				stats.setRatio(roundUp(ratio));
				
				logger.info("Stats: {}", stats);
			}
			
			return stats;
		}
		

		return null;
	}
	
	/**
	 * Rounds double values scale 2
	 * @param value
	 * @return
	 */
	private double roundUp(double value) {
		BigDecimal bigD = BigDecimal.valueOf(value);
		bigD = bigD.setScale(2, RoundingMode.HALF_UP);
		
		return bigD.doubleValue();
	}

	/**
	 * Retrieve all API entries
	 * from DB
	 */
	@Override
	public List<StatsApi> findAll() {
		return jpaRepository.findAll();
	}
}
