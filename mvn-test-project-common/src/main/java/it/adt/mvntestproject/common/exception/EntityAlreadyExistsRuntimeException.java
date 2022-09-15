package it.adt.mvntestproject.common.exception;

public class EntityAlreadyExistsRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -7626117056410177157L;

	public EntityAlreadyExistsRuntimeException() {
		super();
	}

	public EntityAlreadyExistsRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityAlreadyExistsRuntimeException(String message) {
		super(message);
	}
}
