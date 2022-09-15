package it.adt.mvntestproject.common.exception;

public class EntityNotFoundException extends Exception {
    private static final long serialVersionUID = 2819232916015312340L;

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
