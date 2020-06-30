package com.mutants.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadDnaSequenceException extends RuntimeException {

	public BadDnaSequenceException(String msg) {
		super(msg);
	}
}
