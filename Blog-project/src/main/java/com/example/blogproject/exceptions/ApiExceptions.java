package com.example.blogproject.exceptions;

public class ApiExceptions extends RuntimeException {

	public ApiExceptions() {
		super();
	}

	public ApiExceptions(String message) {
		super(message);
	}
}
