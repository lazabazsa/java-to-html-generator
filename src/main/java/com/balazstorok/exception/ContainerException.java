package com.balazstorok.exception;

/**
 * Exception which can be thrown by Container component.
 *
 * Created by Balazs Torok on 12/02/17.
 */
public class ContainerException extends RuntimeException {

	public ContainerException(String message) {
		super(message);
	}
}
