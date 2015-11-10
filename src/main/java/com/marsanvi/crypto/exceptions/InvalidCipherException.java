package com.marsanvi.crypto.exceptions;

public class InvalidCipherException extends Exception {
	public InvalidCipherException() {
		super();
	}

	public InvalidCipherException(String message) {
		super(message);
	}

	public InvalidCipherException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidCipherException(Throwable cause) {
		super(cause);
	}

}
