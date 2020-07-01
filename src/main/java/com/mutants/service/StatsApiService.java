package com.mutants.service;

import java.util.List;
import java.util.Optional;

import com.mutants.entity.StatsApi;
import com.mutants.entity.StatsResult;

public interface StatsApiService {

	StatsApi save(String dnaSequence, int mutantStrings, boolean isMutant);
	
	StatsResult getStats();
	
	List<StatsApi> findAll();
}
