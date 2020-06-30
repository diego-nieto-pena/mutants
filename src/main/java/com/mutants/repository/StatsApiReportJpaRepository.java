package com.mutants.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mutants.entity.StatsApi;
import com.mutants.entity.StatsResult;

public interface StatsApiReportJpaRepository extends JpaRepository<StatsApi, Long> {


}
