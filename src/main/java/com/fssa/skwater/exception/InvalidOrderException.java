package com.fssa.skwater.exception;

public class InvalidOrderException extends Exception {

	private static final long serialVersionUID = 2L;

	public InvalidOrderException(String msg) {
		super(msg);
	}

	public InvalidOrderException(Throwable te) {
		super(te);
	}

	public InvalidOrderException(String msg, Throwable te) {

		super(msg, te);
	}
}
