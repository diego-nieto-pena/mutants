package com.mutants.util;

public class Builder {

	public static String[][] build2dArray(String[] strSeq) {
		String[][] dna = new String[strSeq.length][strSeq.length];
		
		for (int i = 0 ; i < strSeq.length ; i++) {
			dna[i] = strSeq[i].split("");
		}
		
		return dna;
	}
}
