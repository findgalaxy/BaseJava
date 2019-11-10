package com.lm.utils;

public class WorkException extends RuntimeException{
	public WorkException() {
		super();
	}
	public WorkException(String errorMessage) {
		super(errorMessage);
	}
}
