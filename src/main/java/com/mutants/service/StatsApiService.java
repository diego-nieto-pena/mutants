package com.mutants.service;

import java.util.List;

import com.mutants.entity.StatsApi;

public interface StatsApiService {

	StatsApi save(String dnaSequence, int mutantStrings, boolean isMutant);
	
	List<StatsApi> findAll();
}
