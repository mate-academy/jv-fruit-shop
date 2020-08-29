package core.basesyntax.customexceptions;

public class NoSuchOperation extends RuntimeException {
    public NoSuchOperation(String message) {
        super(message);
    }
}
