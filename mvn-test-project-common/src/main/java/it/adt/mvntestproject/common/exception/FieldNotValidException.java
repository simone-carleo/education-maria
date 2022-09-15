package it.adt.mvntestproject.common.exception;

public class FieldNotValidException extends Exception {
    private static final long serialVersionUID = -6173209562946236190L;

    public FieldNotValidException() {
        super();
    }

    public FieldNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public FieldNotValidException(String message) {
        super(message);
    }
}
