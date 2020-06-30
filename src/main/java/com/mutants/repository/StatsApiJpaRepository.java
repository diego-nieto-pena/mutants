package com.mutants.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mutants.entity.StatsApi;

public interface StatsApiJpaRepository extends JpaRepository<StatsApi, Long> {
	@Query(value = "SELECT (select count(*) from hibernate.stats_api where is_mutant = 1) as mutants, count(*) as total  FROM hibernate.stats_api;", nativeQuery = true)
    List<Object[]> statsQuery();
}
