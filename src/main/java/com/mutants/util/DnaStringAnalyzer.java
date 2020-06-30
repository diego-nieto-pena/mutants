package com.mutants.util;

public class DnaStringAnalyzer {

	public static int analyzeSequence(String sequence, int nitroSeqValue) {
		
		int dnaConsecSequence = 0;
		
		int n = sequence.length(); 
        int occurrences = 1; 
  
        for (int i = 0; i < n; i++) { 
            if (i < n - 1 && sequence.charAt(i) == sequence.charAt(i + 1)) {
            	occurrences++;
            } else { 
                occurrences = 1; 
            }
            
    		if(occurrences == nitroSeqValue) {
    			dnaConsecSequence++;
    			occurrences = 1; 
    		}
        } 

    	return dnaConsecSequence;
	}

}
