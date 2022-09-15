package it.adt.mvntestproject.common.exception;

public class EntityAlreadyExistsException extends Exception {

	private static final long serialVersionUID = -6914998124513047873L;

	public EntityAlreadyExistsException() {
		super();
	}

	public EntityAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityAlreadyExistsException(String message) {
		super(message);
	}
}
