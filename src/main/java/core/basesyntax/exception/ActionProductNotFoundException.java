package core.basesyntax.exception;

public class ActionProductNotFoundException extends RuntimeException {
    public ActionProductNotFoundException(String message) {
        super(message);
    }
}
