package com.mutants.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatsResult {

	@SerializedName("count_mutant_dna")
	@Expose(serialize = true)
	private Integer countMutantDna;

	@SerializedName("count_human_dna")
	@Expose(serialize = true)
	private Integer countHumanDna;

	@SerializedName("ratio")
	@Expose(serialize = true)
	private Double ratio;

	public StatsResult() {
	}

	public StatsResult(Integer countMutantDna, Integer countHumanDna, Double ratio) {
		super();
		this.countMutantDna = countMutantDna;
		this.countHumanDna = countHumanDna;
		this.ratio = ratio;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public Integer getCountMutantDna() {
		return countMutantDna;
	}

	public void setCountMutantDna(Integer countMutantDna) {
		this.countMutantDna = countMutantDna;
	}

	public Integer getCountHumanDna() {
		return countHumanDna;
	}

	public void setCountHumanDna(Integer countHumanDna) {
		this.countHumanDna = countHumanDna;
	}

	@Override
	public String toString() {
		return "StatsResult [countMutantDna=" + countMutantDna + ", countHumanDna=" + countHumanDna + ", ratio=" + ratio
				+ "]";
	}
}
