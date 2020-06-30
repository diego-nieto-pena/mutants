package com.mutants.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutants.entity.StatsApi;
import com.mutants.entity.StatsResult;
import com.mutants.repository.StatsApiJpaRepository;
import com.mutants.repository.StatsApiReportJpaRepository;
import com.mutants.service.StatsApiService;

@Service
public class StatsApiServiceImpl implements StatsApiService {

	@Autowired
	private StatsApiJpaRepository jpaRepository;
	
	@Autowired
	private StatsApiReportJpaRepository report;
	
	@Override
	public StatsApi save(String dnaSequence, int mutantStrings, boolean isMutant) {
		
		List<Object[]> statsQuery = jpaRepository.statsQuery();
		
		for(Object[] obj : statsQuery) {
			System.out.println(obj[0] + "---" + obj[1]);
		}
		
		StatsApi newEntry = new StatsApi(dnaSequence, mutantStrings, isMutant);
		return jpaRepository.save(newEntry);
	}

	@Override
	public List<StatsApi> findAll() {
		return jpaRepository.findAll();
	}

}
