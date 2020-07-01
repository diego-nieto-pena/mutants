package com.mutants.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mutants.entity.StatsApi;

public interface StatsApiJpaRepository extends JpaRepository<StatsApi, Long> {
	
	/**
	 * Native query for detector statistics
	 * @return
	 */
	@Query(value = "SELECT (select count(*) from stats_api where is_mutant = 1) as mutants, count(*) as total  FROM stats_api;", nativeQuery = true)
    List<Object[]> statsQuery();
}
