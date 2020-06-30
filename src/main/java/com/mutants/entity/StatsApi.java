package com.mutants.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stats_api")
public class StatsApi {

	@Id
	@GeneratedValue
	private Long id;
	
	private String dnaSequence;
	
	private int mutantSequenceNum;
	
	private Boolean isMutant;
	
	public StatsApi() {
		
	}

	public StatsApi(String dnaSequence, int mutantSequenceNum, Boolean isMutant) {
		super();
		this.dnaSequence = dnaSequence;
		this.mutantSequenceNum = mutantSequenceNum;
		this.isMutant = isMutant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDnaSequence() {
		return dnaSequence;
	}

	public void setDnaSequence(String dnaSequence) {
		this.dnaSequence = dnaSequence;
	}

	public int getMutantSequenceNum() {
		return mutantSequenceNum;
	}

	public void setMutantSequenceNum(int mutantSequenceNum) {
		this.mutantSequenceNum = mutantSequenceNum;
	}

	public Boolean getIsMutant() {
		return isMutant;
	}

	public void setIsMutant(Boolean isMutant) {
		this.isMutant = isMutant;
	}

	@Override
	public String toString() {
		return "StatsApi [id=" + id + ", dnaSequence=" + dnaSequence + ", mutantSequenceNum=" + mutantSequenceNum
				+ ", isMutant=" + isMutant + "]";
	}
}
