package core.basesyntax.exceptions;

public class ServiceNotExistsException extends RuntimeException {
    public ServiceNotExistsException(String message) {
        super(message);
    }
}
