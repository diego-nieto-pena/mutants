package com.mutants.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DnaSequence {

	@SerializedName("dna")
	@Expose
	private List<String> dna = null;

	public List<String> getDna() {
		return dna;
	}

	public void setDna(List<String> dna) {
		this.dna = dna;
	} 
}
