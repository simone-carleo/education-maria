package it.adt.mvntestproject.common.exception;

public class EntityNotFoundRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 7572204682387491764L;

	public EntityNotFoundRuntimeException() {
		super();
	}

	public EntityNotFoundRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotFoundRuntimeException(String message) {
		super(message);
	}
}
